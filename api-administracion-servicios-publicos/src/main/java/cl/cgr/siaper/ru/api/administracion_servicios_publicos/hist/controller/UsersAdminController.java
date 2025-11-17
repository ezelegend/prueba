package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.controller;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.UserDetailsDto;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.UsersSearchResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.CheckDataResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.MetodosFirmaResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ProfilesFilterResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ServicesTreeResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service.UsersAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UsersAdminController {

    private final UsersAdminService service;

    // GET /search?q=texto
    @GetMapping("/search")
    public UsersSearchResponse search(@RequestParam(name = "q", required = false) String q) {
        return service.search(q);
    }

    // GET /init-add
    @GetMapping("/init-add")
    public UserDetailsDto initAdd() {
        return service.newUserTemplate();
    }

    // GET /view-edit/by-codigo?codigo=XXX
    @GetMapping("/view-edit/by-codigo")
    public UserDetailsDto viewEditByCodigo(@RequestParam("codigo") String codigo) {
        return service.getUserDetailsByCodigo(codigo);
    }

    // POST /check-data?run=XXXXXXXX-X
    @PostMapping("/check-data")
    public CheckDataResponse checkData(@RequestParam("run") String run,
                                       @RequestParam(name = "userId", required = false) Long userId) {
        CheckDataRequest req = new CheckDataRequest();
        req.setRun(run);
        req.setUserId(userId);
        return service.checkData(req);
    }

    // PUT /change-service?codigo=XXX&servicioId=Y
    @PutMapping("/change-service")
    public UserDetailsDto changeService(@RequestParam("codigo") String codigo,
                                        @RequestParam("servicioId") Long servicioId) {
        return service.changeServiceByCodigo(codigo, servicioId);
    }

    // POST /save
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDto save(@RequestBody SaveUserRequest req) {
        return service.saveUser(req);
    }

    // PUT /deactivate?codigo=XXX
    @PutMapping("/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(@RequestParam("codigo") String codigo) {
        service.deactivateByCodigo(codigo);
    }

    // PUT /activate?codigo=XXX
    @PutMapping("/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activate(@RequestParam("codigo") String codigo) {
        service.activateByCodigo(codigo);
    }

    // POST /profiles/filter
    @PostMapping("/profiles/filter")
    public ProfilesFilterResponse profilesFilter(@RequestBody SaveProfilesRequest req) {
        return service.profilesFilter(req);
    }

    // PUT /profiles/save
    @PutMapping("/profiles/save")
    public UserDetailsDto profilesSave(@RequestBody SaveProfilesRequest req) {
        return service.profilesSave(req);
    }

    // GET /services-vu/tree?codigo=XXX
    @GetMapping("/services-vu/tree")
    public ServicesTreeResponse servicesVuTree(@RequestParam("codigo") String codigo) {
        return service.servicesVuTree(codigo);
    }

    // PUT /services-vu/save
    @PutMapping("/services-vu/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void servicesVuSave(@RequestBody SaveServiciosRequest req) {
        service.servicesVuSave(req);
    }

    // GET /services-firma/tree?codigo=XXX
    @GetMapping("/services-firma/tree")
    public ServicesTreeResponse servicesFirmaTree(@RequestParam("codigo") String codigo) {
        return service.servicesFirmaTree(codigo);
    }

    // PUT /services-firma/save
    @PutMapping("/services-firma/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void servicesFirmaSave(@RequestBody SaveServiciosRequest req) {
        service.servicesFirmaSave(req);
    }

    // GET /metodos-firma?codigo=XXX&servicioId=Y
    @GetMapping("/metodos-firma")
    public MetodosFirmaResponse metodosFirma(@RequestParam("codigo") String codigo,
                                             @RequestParam("servicioId") Long servicioId) {
        return service.metodosFirmaGet(codigo, servicioId);
    }

    // PUT /metodos-firma/save
    @PutMapping("/metodos-firma/save")
    public UserDetailsDto metodosFirmaSave(@RequestBody SaveMetodosFirmaRequest req) {
        return service.metodosFirmaSave(req);
    }
}