package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service.impl;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.config.TransversalesClient;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.constant.Constantes;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.CheckDataResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.MetodosFirmaResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ProfilesFilterResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ServicesTreeResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker.Invoker;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker.InvokerException;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker.InvokerResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.repository.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service.UsersAdminService;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.utils.ValidacionBean;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.validator.ValidatorException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UsersAdminServiceImpl implements UsersAdminService {

    private final Invoker invoker;
    private final ValidacionBean validacionBean;

    private final UsersRepository usuarioRepo;
    private final ServicioRepository servicioRepo;
    private final PerfilRepository perfilRepo;
    private final UsuarioPerfilRepository usuarioPerfilRepo;
    private final UsuarioServicioRepository usuarioServicioRepo;
    private final SubrogacionRepository subrogacionRepo;
    private final FirmanteAdjuntoRepository firmanteAdjuntoRepo;
    private final MetodoFirmaRepository metodoFirmaRepo;
    private final MetodoFirmaRelacionRepository metodoFirmaRelacionRepo;
    private final FirmanteCgrRepository firmanteCgrRepo;
    private final FirmanteCgrConfigRepository firmanteCgrConfigRepo;
    private final AccesoEscritorioRepository accesoEscritorioRepo;
    private final TransversalesClient transversalesClient;

    @Override
    @Transactional(readOnly = true)
    public UsersSearchResponse search(String valueSearch) {
        List<Usuario> activos = usuarioRepo.searchActivos(valueSearch);
        List<Usuario> inactivos = usuarioRepo.searchInactivos(valueSearch);

        return UsersSearchResponse.builder()
                .active(activos.stream().map(this::toUserSummary).collect(Collectors.toList()))
                .inactive(inactivos.stream().map(this::toUserSummary).collect(Collectors.toList()))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetailsDto newUserTemplate() {
        return UserDetailsDto.builder()
                .editItem(false)
                .checkValidator(false)
                .existData(true)
                .habilitarAccesoEscritorio(false)
                .verServicioFirma(false)
                .verServicioVU(false)
                .perfilesAsociados(Collections.emptyList())
                .perfilesDisponibles(perfilRepo.findAll().stream().map(this::toProfile).toList())
                .metodosFirmaAsociados(Collections.emptyList())
                .metodosFirmaDisponibles(metodoFirmaRepo.findAll().stream().map(this::toMetodoFirma).toList())
                .contralorias(servicioRepo.obtenerContralorias().stream().map(this::toService).toList())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetailsDto getUserDetailsByCodigo(String codigo) {
        Usuario u = usuarioRepo.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return buildDetails(u);
    }

    @Override
    public CheckDataResponse checkData(CheckDataRequest request) {
        String runUser = request.getRun();
        if (StringUtils.isBlank(runUser)) {
            return CheckDataResponse.notFound("Indica un RUN");
        }
        try {
            validacionBean.validarRut(runUser);
            List<Usuario> lu = usuarioRepo.searchByRun(runUser);
            boolean libre = true;
            for (Usuario u : lu) {
                if (request.getUserId() == null || !u.getId().equals(request.getUserId())) {
                    libre = false;
                }
            }
            if (!libre) {
                return CheckDataResponse.error("Ya existe un usuario con el mismo código o RUT");
            }
            if (lu != null && !lu.isEmpty()) {
                Usuario u = null;
                if (request.getUserId() != null) {
                    for (Usuario cand : lu) {
                        if (request.getUserId().equals(cand.getId())) {
                            u = cand;
                            break;
                        }
                    }
                }
                if (u == null) u = lu.get(0);
                return CheckDataResponse.found(u.getNombre(), u.getApellido1(), u.getApellido2(), u.getEmail());
            }
            var opt = transversalesClient.findPersonByRun(runUser);
            if (opt.isPresent()) {
                var p = opt.get();
                String email = transversalesClient.findEmailByRun(runUser).orElse(null);
                return CheckDataResponse.found(p.getNombres(), p.getApellidoPaterno(), p.getApellidoMaterno(), email);
            } else {
                return CheckDataResponse.notFound("No se encontraron datos del RUN en SIAPER/Registro Civil.");
            }
        } catch (ValidatorException e) {
            return CheckDataResponse.error("RUN inválido.");
        } catch (Exception e) {
            log.error("Error en checkData", e);
            return CheckDataResponse.error("No se ha podido conectar con SIAPER.");
        }
    }

    private String safeText(JsonNode node, String field) {
        if (node == null || node.get(field) == null || node.get(field).isNull()) return null;
        String s = node.get(field).asText();
        return StringUtils.isBlank(s) ? null : s.trim();
    }

    @Override
    @Transactional
    public UserDetailsDto saveUser(SaveUserRequest req) {
        if (StringUtils.isBlank(req.getCodUser()) || StringUtils.isBlank(req.getRunUser())) {
            throw new IllegalArgumentException("Campos obligatorios faltantes: codUser y runUser");
        }
        if (StringUtils.isNotBlank(req.getEmail()) && !isEmail(req.getEmail())) {
            throw new IllegalArgumentException("El Correo Electrónico introducido no es correcto.");
        }

        Servicio servicioSelect = resolveService(req.getServiceId());
        if (servicioSelect == null || servicioSelect.getId() == null) {
            throw new IllegalArgumentException("Debe seleccionar un servicio");
        }

        try {
            String runNormalized = req.getRunUser().trim().replaceAll("[\\.\\s]", "");
            validacionBean.validarRut(runNormalized);

            Usuario duplicated = usuarioRepo.findByRunOrCodigo(runNormalized, req.getCodUser()).orElse(null);
            if (duplicated != null && (req.getUserId() == null || !duplicated.getId().equals(req.getUserId()))) {
                throw new IllegalArgumentException("Ya existe un usuario con el mismo código o RUT");
            }

            Usuario user;
            Servicio servicioInicialUsu = null;
            boolean isCreate = (req.getUserId() == null);

            if (!isCreate) {
                user = usuarioRepo.findById(req.getUserId())
                        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
                servicioInicialUsu = user.getServicio();
            } else {
                user = new Usuario();
                user.setActivo(true);
            }

            if (Boolean.TRUE.equals(req.isCheckFirmante()) && req.getCalidadFirmante() == null) {
                throw new IllegalArgumentException("Debe seleccionar la calidad de firmante (TITULAR/SUBROGANTE)");
            }

            user.setCodigo(req.getCodUser());
            user.setNombre(req.getNameUser());
            user.setApellido1(req.getApe1User());
            user.setApellido2(req.getApe2User());
            if (req.getEmail() != null) user.setEmail(req.getEmail());
            user.setConfigFirma(req.getConfigHSM());
            user.setConfigFirmaPDF(req.getConfigHSMPDF());
            user.setUsuarioConfigFirma(req.getUsuarioFirmante());
            user.setRun(runNormalized);

            if (user.getServicio() == null) {
                user.setServicio(servicioSelect);
            } else if (servicioInicialUsu != null && !Objects.equals(servicioInicialUsu.getId(), servicioSelect.getId())) {
                List<Subrogacion> lSubrogaciones = subrogacionRepo.consultarSubroganciasUsuario(user, servicioInicialUsu);
                if (lSubrogaciones != null) {
                    for (Subrogacion sub : lSubrogaciones) {
                        subrogacionRepo.delete(sub);
                    }
                }
                Usuario userInactive = user;
                userInactive.setServicio(servicioInicialUsu);
                validaCalidadFirmante(userInactive, false, req.getCalidadFirmante());
            }

            user.setServicio(servicioSelect);

            user = usuarioRepo.save(user);

            validaCalidadFirmante(user, Boolean.TRUE.equals(req.isCheckFirmante()), req.getCalidadFirmante());

            if (req.getFlagTieneFirmaHSM() != null && req.getFlagTieneFirmaHSM()) {
                MetodoFirma mt = metodoFirmaRepo.findByCodigo(Constantes.METODO_HSM_INTERNO)
                        .orElseThrow(() -> new IllegalArgumentException("Método HSM no encontrado"));
                MetodoFirmaRelacion mtr = metodoFirmaRelacionRepo.findByIds(user.getId(), servicioSelect.getId(), mt.getId()).orElse(null);
                if (mtr != null) {
                    boolean random = Boolean.TRUE.equals(req.getClaveFirmaRandom());
                    mtr.setClaveAleatoria(random);
                    mtr.setFirmaUnica(!random);
                    metodoFirmaRelacionRepo.save(mtr);
                }
            }

            if (Boolean.TRUE.equals(req.getVerServicioVU())) {
                guardarAccesoEscritorio(user, Boolean.TRUE.equals(req.getHabilitarAccesoEscritorio()));
            }

            if (req.getMetodosFirma() != null) {
                Set<String> wantedCodes = req.getMetodosFirma().stream()
                        .filter(Objects::nonNull)
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toCollection(LinkedHashSet::new));

                List<MetodoFirmaRelacion> actuales = metodoFirmaRelacionRepo.findByUsuarioIdAndServicioId(user.getId(), servicioSelect.getId());
                Map<String, MetodoFirmaRelacion> actualesPorCodigo = actuales.stream()
                        .filter(r -> r.getMetodoFirma() != null && r.getMetodoFirma().getCodigo() != null)
                        .collect(Collectors.toMap(r -> r.getMetodoFirma().getCodigo(), Function.identity(), (a, b) -> a));

                for (MetodoFirmaRelacion rel : actuales) {
                    String codigoRel = rel.getMetodoFirma() != null ? rel.getMetodoFirma().getCodigo() : null;
                    if (codigoRel == null) continue;
                    if (!wantedCodes.contains(codigoRel)) {
                        metodoFirmaRelacionRepo.delete(rel);
                    }
                }

                for (String code : wantedCodes) {
                    MetodoFirmaRelacion existing = actualesPorCodigo.get(code);
                    if (existing != null) {
                        metodoFirmaRelacionRepo.save(existing);
                        continue;
                    }

                    MetodoFirma metodo = metodoFirmaRepo.findByCodigo(code)
                            .orElseThrow(() -> new IllegalArgumentException("Método de firma no encontrado: " + code));

                    MetodoFirmaRelacion nueva = new MetodoFirmaRelacion();
                    nueva.setUsuario(user);
                    nueva.setServicio(servicioSelect);
                    nueva.setMetodoFirma(metodo);

                    boolean defaultRandom = Boolean.FALSE;
                    nueva.setClaveAleatoria(defaultRandom);
                    nueva.setFirmaUnica(!defaultRandom);

                    metodoFirmaRelacionRepo.save(nueva);
                }
            }

            return buildDetails(user);
        } catch (ValidatorException e) {
            throw new IllegalArgumentException("RUN inválido.");
        }
    }

    @Override
    public void activateByCodigo(String codigo) {
        Usuario u = usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        u.setActivo(true);
        usuarioRepo.save(u);
        validaCalidadFirmante(u, true, null);
    }

    @Override
    public void deactivateByCodigo(String codigo) {
        Usuario u = usuarioRepo.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        u.setActivo(false);
        usuarioRepo.save(u);
    }

    @Override
    public UserDetailsDto changeServiceByCodigo(String codigo, Long serviceId) {
        Usuario u = usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Servicio serv = resolveService(serviceId);
        u.setServicio(serv);
        usuarioRepo.save(u);

        boolean checkFirmante = isFirmanteOrFirmanteCgr(u) && isContraloria(serv);
        if (checkFirmante) {
            consultaCalidadFirmante(u);
        }
        return buildDetails(u);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfilesFilterResponse profilesFilter(SaveProfilesRequest req) {
        Usuario user = usuarioRepo.findByCodigo(req.getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        List<Perfil> actuales = usuarioPerfilRepo.findPerfilesByUsuarioId(user.getId());
        List<Perfil> todos = perfilRepo.findAll();

        List<Perfil> disponibles = new ArrayList<>(todos);
        disponibles.removeAll(actuales);

        boolean verServicioFirma = actuales.stream().anyMatch(p -> Constantes.FIRMANTE.equals(p.getNombre()));
        boolean verServicioVU = actuales.stream().anyMatch(p ->
                Constantes.GESTOR.equals(p.getNombre()) || Constantes.FIRMANTE_ESTAMPA.equals(p.getNombre())
        );
        boolean checkFirmante = isFirmanteOrFirmanteCgr(actuales) && isContraloria(user.getServicio());

        String calidadFirmante = getCalidadFirmante(user);

        ProfilesFilterResponse resp = new ProfilesFilterResponse();
        resp.setPerfilesAsociados(actuales.stream().map(this::toProfile).collect(Collectors.toList()));
        resp.setPerfilesDisponibles(disponibles.stream().map(this::toProfile).collect(Collectors.toList()));
        resp.setVerServicioFirma(verServicioFirma);
        resp.setVerServicioVU(verServicioVU);
        resp.setCheckFirmante(checkFirmante);
        resp.setCalidadFirmante(calidadFirmante);
        return resp;
    }

    @Override
    public UserDetailsDto profilesSave(SaveProfilesRequest req) {
        Usuario user = usuarioRepo.findByCodigo(req.getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        user = usuarioRepo.findByCodigo(user.getCodigo()).orElseThrow(); // refresh

        List<Perfil> actuales = usuarioPerfilRepo.findPerfilesByUsuarioId(user.getId());
        List<Perfil> nuevos = perfilRepo.findAllById(req.getProfileIds());

        Optional<Perfil> supCgr = nuevos.stream().filter(p -> Constantes.SUPERVISOR_CGR.equals(p.getNombre())).findAny();
        if (supCgr.isPresent() && nuevos.size() > 1) {
            throw new IllegalArgumentException("El perfil SUPERVISOR_CGR no puede combinarse con otros perfiles");
        }

        Set<UsuarioPerfil> aEliminar = new HashSet<>();
        for (Perfil per : actuales) {
            if (!nuevos.contains(per)) {
                // encontrar enlace y marcar para eliminar
                usuarioPerfilRepo.findByUsuarioIdAndPerfilId(user.getId(), per.getId())
                        .ifPresent(aEliminar::add);

                // efectos colaterales por rol removido
                if (Constantes.CONTRALOR.equals(per.getNombre())) {
                    subrogacionRepo.consultarSubrogados(user, Constantes.CONTRALOR).forEach(subrogacionRepo::delete);
                } else if (Constantes.JEFE_AREA.equals(per.getNombre())) {
                    subrogacionRepo.consultarSubrogados(user, Constantes.JEFE_AREA).forEach(subrogacionRepo::delete);
                }
                if (Constantes.FIRMANTE.equals(per.getNombre())) {
                    firmanteAdjuntoRepo.findByUsuarioFirmanteId(user.getId()).forEach(firmanteAdjuntoRepo::delete);
                    metodoFirmaRelacionRepo.findByUsuarioIdAndServicioId(user.getId(),
                                    user.getServicio() != null ? user.getServicio().getId() : null)
                            .forEach(metodoFirmaRelacionRepo::delete);
                }
            }
        }

        Set<UsuarioPerfil> aAgregar = new HashSet<>();
        for (Perfil p : nuevos) {
            if (!actuales.contains(p)) {
                UsuarioPerfil up = new UsuarioPerfil();
                up.setUsuario(user);
                up.setPerfil(p);
                aAgregar.add(up);
            }
        }

        if (!aAgregar.isEmpty()) usuarioPerfilRepo.saveAll(aAgregar);
        if (!aEliminar.isEmpty()) usuarioPerfilRepo.deleteAll(aEliminar);

        boolean verServicioVU = nuevos.stream().anyMatch(p ->
                Constantes.GESTOR.equals(p.getNombre()) || Constantes.FIRMANTE_ESTAMPA.equals(p.getNombre()));
        boolean checkFirmante = isFirmanteOrFirmanteCgr(nuevos) && isContraloria(user.getServicio());
        validaCalidadFirmante(user, checkFirmante, req.getCalidadFirmante());

        return buildDetails(user);
    }

    @Override
    @Transactional(readOnly = true)
    public ServicesTreeResponse servicesVuTree(String codigo) {
        Usuario user = usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        List<Servicio> seleccionados = usuarioServicioRepo.findServiciosActivosByUsuarioId(user.getId());
        List<Servicio> todos = servicioRepo.findAll();

        return ServicesTreeResponse.of(todos, seleccionados);
    }

    @Override
    public void servicesVuSave(SaveServiciosRequest req) {
        Usuario user = usuarioRepo.findByCodigo(req.getCodigo()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Set<Long> nuevos = new HashSet<>(Optional.ofNullable(req.getServiceIds()).orElseGet(Collections::emptyList));

        List<Servicio> actuales = usuarioServicioRepo.findServiciosActivosByUsuarioId(user.getId());
        for (Servicio s : actuales) {
            if (!nuevos.contains(s.getId())) {
                usuarioServicioRepo.findByUsuarioIdAndServicioId(user.getId(), s.getId())
                        .ifPresent(us -> {
                            us.setActivo(false);
                            usuarioServicioRepo.save(us);
                        });
            }
        }
        for (Long id : nuevos) {
            Servicio serv = servicioRepo.findById(id).orElse(null);
            if (serv == null) continue;
            UsuarioServicio us = usuarioServicioRepo.findByUsuarioIdAndServicioId(user.getId(), id).orElse(null);
            if (us == null) {
                us = new UsuarioServicio();
                us.setUsuario(user);
                us.setServicio(serv);
                us.setActivo(true);
                usuarioServicioRepo.save(us);
            } else {
                us.setActivo(true);
                usuarioServicioRepo.save(us);
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ServicesTreeResponse servicesFirmaTree(String codigo) {
        Usuario user = usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        List<Servicio> seleccionados = firmanteAdjuntoRepo.findServiciosByUsuarioFirmanteId(user.getId());
        List<Servicio> todos = servicioRepo.findAll();
        return ServicesTreeResponse.of(todos, seleccionados);
    }

    @Override
    public void servicesFirmaSave(SaveServiciosRequest req) {
        Usuario user = usuarioRepo.findByCodigo(req.getCodigo()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Set<Long> nuevosSet = new HashSet<>(Optional.ofNullable(req.getServiceIds()).orElseGet(Collections::emptyList));

        List<Servicio> actuales = firmanteAdjuntoRepo.findServiciosByUsuarioFirmanteId(user.getId());

        // Borrar
        for (Servicio s : actuales) {
            if (!nuevosSet.contains(s.getId())) {
                firmanteAdjuntoRepo.findByUsuarioAndServicio(user.getId(), s.getId())
                        .ifPresent(firmanteAdjuntoRepo::delete);
            }
        }
        // Agregar
        for (Long id : nuevosSet) {
            Servicio serv = servicioRepo.findById(id).orElse(null);
            if (serv == null) continue;
            if (actuales.stream().noneMatch(s -> Objects.equals(s.getId(), id))) {
                FirmanteAdjunto fa = new FirmanteAdjunto();
                fa.setUsuarioFirmante(user);
                fa.setServicioFirmante(serv);
                firmanteAdjuntoRepo.save(fa);
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MetodosFirmaResponse metodosFirmaGet(String codigo, Long servicioId) {
        Usuario user = usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Servicio serv = resolveService(servicioId);

        List<MetodoFirma> asignados = metodoFirmaRepo.consultarMetodosFirma(user.getId(), serv.getId());
        List<MetodoFirma> todos = metodoFirmaRepo.findAll();

        List<MetodoFirma> disponibles = new ArrayList<>(todos);
        disponibles.removeAll(asignados);

        boolean flagHsm = asignados.stream().anyMatch(m -> Constantes.METODO_HSM_INTERNO.equalsIgnoreCase(m.getCodigo()));
        Boolean claveRandom = null;
        if (flagHsm) {
            MetodoFirma mt = metodoFirmaRepo.findByCodigo(Constantes.METODO_HSM_INTERNO).orElse(null);
            if (mt != null) {
                MetodoFirmaRelacion mtr = metodoFirmaRelacionRepo.findByIds(user.getId(), serv.getId(), mt.getId()).orElse(null);
                claveRandom = (mtr != null && mtr.isClaveAleatoria());
            }
        }

        MetodosFirmaResponse resp = new MetodosFirmaResponse();
        resp.setAsociados(asignados.stream().map(this::toMetodoFirma).collect(Collectors.toList()));
        resp.setDisponibles(disponibles.stream().map(this::toMetodoFirma).collect(Collectors.toList()));
        resp.setFlagTieneFirmaHSM(flagHsm);
        resp.setClaveFirmaRandom(claveRandom);
        return resp;
    }

    @Override
    public UserDetailsDto metodosFirmaSave(SaveMetodosFirmaRequest req) {
        Usuario user = usuarioRepo.findByCodigo(req.getCodigo()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Servicio serv = resolveService(req.getServicioId());

        List<Long> metodoIds = Optional.ofNullable(req.getMetodoIds()).orElseGet(Collections::emptyList);

        if (metodoIds.isEmpty()) {
            metodoFirmaRelacionRepo.findByUsuarioIdAndServicioId(user.getId(), serv.getId())
                    .forEach(metodoFirmaRelacionRepo::delete);
            return buildDetails(user);
        }

        List<MetodoFirma> actuales = metodoFirmaRepo.consultarMetodosFirma(user.getId(), serv.getId());
        List<MetodoFirma> todos = metodoFirmaRepo.findAll();
        Map<Long, MetodoFirma> porId = todos.stream().collect(Collectors.toMap(MetodoFirma::getId, x -> x));
        List<MetodoFirma> nuevos = metodoIds.stream().map(porId::get).filter(Objects::nonNull).collect(Collectors.toList());

        // Borrar los que salieron
        for (MetodoFirma lm : todos) {
            if (actuales.contains(lm) && !nuevos.contains(lm)) {
                MetodoFirmaRelacion rel = metodoFirmaRelacionRepo.findByIds(user.getId(), serv.getId(), lm.getId()).orElse(null);
                if (rel != null) metodoFirmaRelacionRepo.delete(rel);
            }
        }
        // Agregar nuevos
        for (MetodoFirma lm : nuevos) {
            if (!actuales.contains(lm)) {
                MetodoFirmaRelacionPK pk = new MetodoFirmaRelacionPK(user.getId(), serv.getId(), lm.getId());
                MetodoFirmaRelacion mtr = new MetodoFirmaRelacion(pk, false, true, user, serv, lm);
                metodoFirmaRelacionRepo.save(mtr);
            }
        }

        boolean tieneHsm = nuevos.stream().anyMatch(m -> Constantes.METODO_HSM_INTERNO.equalsIgnoreCase(m.getCodigo()));
        if (tieneHsm) {
            MetodoFirma mt = metodoFirmaRepo.findByCodigo(Constantes.METODO_HSM_INTERNO).orElseThrow();
            MetodoFirmaRelacion mtr = metodoFirmaRelacionRepo.findByIds(user.getId(), serv.getId(), mt.getId()).orElse(null);
            if (mtr != null) {
                boolean random = Boolean.TRUE.equals(req.getClaveRandom());
                mtr.setClaveAleatoria(random);
                mtr.setFirmaUnica(!random);
                metodoFirmaRelacionRepo.save(mtr);
            }
        }

        return buildDetails(user);
    }

    // =================== Helpers ===================

    private UsersSearchResponse.UserSummary toUserSummary(Usuario u) {
        return UsersSearchResponse.UserSummary.builder()
                .id(u.getId())
                .codigo(u.getCodigo())
                .run(u.getRun())
                .nombre(u.getNombre())
                .apellido1(u.getApellido1())
                .apellido2(u.getApellido2())
                .servicio(u.getServicio() != null ? u.getServicio().getDescripcion() : null)
                .activo(u.getActivo() != null ? u.getActivo() : false)
                .build();
    }

    private ProfileDto toProfile(Perfil p) {
        return ProfileDto.builder().id(p.getId()).nombre(p.getNombre()).build();
    }

    private ServiceDto toService(Servicio s) {
        return ServiceDto.builder().id(s.getId()).descripcion(s.getDescripcion()).build();
    }

    private MetodoFirmaDto toMetodoFirma(MetodoFirma m) {
        return MetodoFirmaDto.builder().id(m.getId()).codigo(m.getCodigo()).build();
    }

    private Servicio resolveService(Long id) {
        if (id == null) return null;
        return servicioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));
    }

    private boolean isContraloria(Servicio servicio) {
        if (servicio == null) return false;
        List<Servicio> contr = servicioRepo.obtenerContralorias();
        for (Servicio c : contr) {
            if (c.getId().equals(servicio.getId())) return true;
        }
        return false;
    }

    private boolean isFirmanteOrFirmanteCgr(Usuario u) {
        List<Perfil> perfiles = usuarioPerfilRepo.findPerfilesByUsuarioId(u.getId());
        return isFirmanteOrFirmanteCgr(perfiles);
    }

    private boolean isFirmanteOrFirmanteCgr(List<Perfil> perfiles) {
        if (perfiles == null) return false;
        for (Perfil p : perfiles) {
            if (Constantes.FIRMANTE.equals(p.getNombre()) || Constantes.FIRMANTE_CGR.equals(p.getNombre())) return true;
        }
        return false;
    }

    private String getCalidadFirmante(Usuario user) {
        var firmantes = firmanteCgrRepo.findByUsuarioId(user.getId());
        if (firmantes != null && !firmantes.isEmpty()) {
            return String.valueOf(firmantes.get(0).getCalidadFirmante());
        }
        return null;
    }

    private void consultaCalidadFirmante(Usuario user) {
        getCalidadFirmante(user);
    }

    private void guardarCalidadFirmante(Usuario user, String calidadFirmante) {
        if (calidadFirmante == null) return;
        FirmanteCgr fc = new FirmanteCgr();
        fc.setActivo(true);
        fc.setCalidadFirmante(Long.valueOf(calidadFirmante));
        fc.setServicioFirmante(user.getServicio());
        fc.setUsuarioFirmanteCgr(user);
        fc.setVersion(new Date());
        firmanteCgrRepo.save(fc);
    }

    private void validaCalidadFirmante(Usuario user, Boolean activo, String calidadFirmante) {
        List<FirmanteCgr> firmantes = firmanteCgrRepo.findByUsuarioId(user.getId());
        List<FirmanteCgrConfig> firmantesConfig = new ArrayList<>();

        if (firmantes != null && !firmantes.isEmpty()) {
            for (FirmanteCgr f : firmantes) {
                f.setActivo(Boolean.TRUE.equals(activo));
                if (calidadFirmante != null) {
                    f.setCalidadFirmante(Long.valueOf(calidadFirmante));
                }
                firmanteCgrRepo.save(f);
                firmantesConfig = firmanteCgrConfigRepo.findByFirmanteId(f.getId());
            }
        } else {
            if (isContraloria(user.getServicio()) && calidadFirmante != null) {
                guardarCalidadFirmante(user, calidadFirmante);
            }
        }

        if (firmantesConfig != null && !firmantesConfig.isEmpty()) {
            Long idFirmante = firmantesConfig.get(0).getFirmanteCgr().getId();
            Long idServicio = firmantesConfig.get(0).getServicioFirmante().getId();
            firmanteCgrConfigRepo.updateEstadoByFirmanteAndServicio(idFirmante, Boolean.TRUE.equals(activo), idServicio);
        }
    }

    private void guardarAccesoEscritorio(Usuario usuario, boolean habilita) {
        String[] runArray = usuario.getRun().split("-");
        Long run = Long.valueOf(runArray[0]);
        String dv = runArray.length > 1 ? runArray[1] : null;

        Optional<AccesoEscritorio> habilitado = accesoEscritorioRepo.findByRunAndEstado(run, 1);
        Optional<AccesoEscritorio> deshabilitado = accesoEscritorioRepo.findByRunAndEstado(run, 0);

        AccesoEscritorio ae = habilitado.orElseGet(() -> deshabilitado.orElseGet(AccesoEscritorio::new));
        ae.setRun(run);
        ae.setDv(dv);
        ae.setEstado(habilita ? 1 : 0);
        accesoEscritorioRepo.save(ae);
    }

    private UserDetailsDto buildDetails(Usuario u) {
        List<Perfil> asociados = usuarioPerfilRepo.findPerfilesByUsuarioId(u.getId());
        List<Perfil> todosPerf = perfilRepo.findAll();
        List<Perfil> disponibles = new ArrayList<>(todosPerf);
        disponibles.removeAll(asociados);

        boolean verServicioFirma = asociados.stream().anyMatch(p -> Constantes.FIRMANTE.equals(p.getNombre()));
        boolean verServicioVU = asociados.stream().anyMatch(p ->
                Constantes.GESTOR.equals(p.getNombre()) || Constantes.FIRMANTE_ESTAMPA.equals(p.getNombre())
        );
        boolean checkFirmante = isFirmanteOrFirmanteCgr(asociados) && isContraloria(u.getServicio());

        List<MetodoFirma> asignados = (u.getServicio() != null && u.getId() != null)
                ? metodoFirmaRepo.consultarMetodosFirma(u.getId(), u.getServicio().getId())
                : Collections.emptyList();
        List<MetodoFirma> todos = metodoFirmaRepo.findAll();
        List<MetodoFirma> disponiblesMet = new ArrayList<>(todos);
        disponiblesMet.removeAll(asignados);

        boolean flagHsm = asignados.stream().anyMatch(m -> Constantes.METODO_HSM_INTERNO.equalsIgnoreCase(m.getCodigo()));
        Boolean claveRandom = null;
        if (flagHsm && u.getServicio() != null) {
            MetodoFirma mt = metodoFirmaRepo.findByCodigo(Constantes.METODO_HSM_INTERNO).orElse(null);
            if (mt != null) {
                MetodoFirmaRelacion mtr = metodoFirmaRelacionRepo.findByIds(u.getId(), u.getServicio().getId(), mt.getId()).orElse(null);
                claveRandom = (mtr != null && mtr.isClaveAleatoria());
            }
        }

        Boolean habilitarAccesoEscritorio = null;
        if (u.getRun() != null) {
            String[] arr = u.getRun().split("-");
            if (arr.length > 0) {
                try {
                    Long run = Long.valueOf(arr[0]);
                    habilitarAccesoEscritorio = accesoEscritorioRepo.findByRunAndEstado(run, 1).isPresent();
                } catch (Exception ignore) { }
            }
        }

        return UserDetailsDto.builder()
                .userId(u.getId())
                .codUser(u.getCodigo())
                .runUser(u.getRun())
                .nameUser(u.getNombre())
                .ape1User(u.getApellido1())
                .ape2User(u.getApellido2())
                .email(u.getEmail())
                .configHSM(u.getConfigFirma())
                .configHSMPDF(u.getConfigFirmaPDF())
                .usuarioFirmante(u.getUsuarioConfigFirma())
                .serviceId(u.getServicio() != null ? u.getServicio().getId() : null)
                .serviceDescripcion(u.getServicio() != null ? u.getServicio().getDescripcion() : null)
                .editItem(true)
                .checkValidator(true)
                .existData(true)
                .perfilesAsociados(asociados.stream().map(this::toProfile).collect(Collectors.toList()))
                .perfilesDisponibles(disponibles.stream().map(this::toProfile).collect(Collectors.toList()))
                .metodosFirmaAsociados(asignados.stream().map(this::toMetodoFirma).collect(Collectors.toList()))
                .metodosFirmaDisponibles(disponiblesMet.stream().map(this::toMetodoFirma).collect(Collectors.toList()))
                .verServicioFirma(verServicioFirma)
                .verServicioVU(verServicioVU)
                .checkFirmante(checkFirmante)
                .flagTieneFirmaHSM(flagHsm)
                .claveFirmaRandom(claveRandom)
                .contralorias(servicioRepo.obtenerContralorias().stream().map(this::toService).collect(Collectors.toList()))
                .habilitarAccesoEscritorio(habilitarAccesoEscritorio)
                .calidadFirmante(getCalidadFirmante(u))
                .build();
    }

    private boolean isEmail(String email) {
        return email != null && email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    private List<String[]> buscarSiaperServicioWeb(String idServicioWeb, String[] args) throws InvokerException {
        InvokerResponse response = invoker.invoke(idServicioWeb, args);
        return response.getStringList();
    }
}