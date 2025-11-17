package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.service;


import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.UserDetailsDto;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.UsersSearchResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.request.*;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.CheckDataResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.MetodosFirmaResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ProfilesFilterResponse;
import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response.ServicesTreeResponse;

public interface UsersAdminService {
    UsersSearchResponse search(String q);
    UserDetailsDto newUserTemplate();
    UserDetailsDto getUserDetailsByCodigo(String codigo);
    CheckDataResponse checkData(CheckDataRequest request);
    UserDetailsDto saveUser(SaveUserRequest req);
    void activateByCodigo(String codigo);
    void deactivateByCodigo(String codigo);
    UserDetailsDto changeServiceByCodigo(String codigo, Long serviceId);
    ProfilesFilterResponse profilesFilter(SaveProfilesRequest req);
    UserDetailsDto profilesSave(SaveProfilesRequest req);
    ServicesTreeResponse servicesVuTree(String codigo);
    void servicesVuSave(SaveServiciosRequest req);
    ServicesTreeResponse servicesFirmaTree(String codigo);
    void servicesFirmaSave(SaveServiciosRequest req);
    MetodosFirmaResponse metodosFirmaGet(String codigo, Long serviceId);
    UserDetailsDto metodosFirmaSave(SaveMetodosFirmaRequest req);
}