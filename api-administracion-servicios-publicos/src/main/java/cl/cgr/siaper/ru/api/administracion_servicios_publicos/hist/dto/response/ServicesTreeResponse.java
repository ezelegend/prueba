package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.dto.response;

import cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.Servicio;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class ServicesTreeResponse {

    @Data
    public static class Node {
        private Long id;
        private String descripcion;
        private boolean selected;
        private List<Node> children = new ArrayList<>();
    }

    private List<Node> tree = new ArrayList<>();

    public static ServicesTreeResponse of(List<Servicio> todos, List<Servicio> seleccionados) {
        Set<Long> selectedIds = seleccionados.stream().map(Servicio::getId).collect(Collectors.toSet());
        Map<Long, Node> map = new HashMap<>();
        for (Servicio s : todos) {
            Node n = new Node();
            n.setId(s.getId());
            n.setDescripcion(s.getDescripcion());
            n.setSelected(selectedIds.contains(s.getId()));
            map.put(s.getId(), n);
        }
        List<Node> roots = new ArrayList<>();
        for (Servicio s : todos) {
            if (s.getServicio() != null && s.getServicio().getId() != null) {
                Node parent = map.get(s.getServicio().getId());
                if (parent != null) parent.getChildren().add(map.get(s.getId()));
                else roots.add(map.get(s.getId()));
            } else {
                roots.add(map.get(s.getId()));
            }
        }
        ServicesTreeResponse resp = new ServicesTreeResponse();
        resp.tree = roots;
        return resp;
    }
}