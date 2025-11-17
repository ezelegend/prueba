package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.controller;

import java.util.List;

public record PagedResponse<T>(
    List<T> content,
    long totalElements,
    int totalPages,
    int pageNumber,  // 1-based para el front
    int pageSize
) {}