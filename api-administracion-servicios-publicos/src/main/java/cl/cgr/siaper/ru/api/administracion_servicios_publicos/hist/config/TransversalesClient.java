package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransversalesClient {

    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${api.transversales.url}")
    private String transversalesUrl;

    private static final String IDENTIFICACION_PATH = "/siaper/identificacionRun";
    private static final String BUSCAR_EMAIL_PATH = "/siaper/buscarEmail";

    public Optional<PersonInfo> findPersonByRun(String runWithDv) {
        if (StringUtils.isBlank(runWithDv)) return Optional.empty();
        try {
            String url = buildUrlWithPath(transversalesUrl, IDENTIFICACION_PATH) + "?params=" + URLEncoder.encode(runWithDv, StandardCharsets.UTF_8);
            String body = webClient.get().uri(url).retrieve().bodyToMono(String.class).block();
            if (body == null) return Optional.empty();
            JsonNode root = objectMapper.readTree(body);
            if (root.isArray() && root.size() > 0) {
                JsonNode f = root.get(0);
                String nombres = text(f, "IDENOMBRES");
                String ape1 = text(f, "IDEAPELLIDOPATERNO");
                String ape2 = text(f, "IDEAPELLIDOMATERNO");
                return Optional.of(new PersonInfo(nombres, ape1, ape2, null));
            }
            if (root.isObject()) {
                String nombres = text(root, "IDENOMBRES");
                String ape1 = text(root, "IDEAPELLIDOPATERNO");
                String ape2 = text(root, "IDEAPELLIDOMATERNO");
                return Optional.of(new PersonInfo(nombres, ape1, ape2, null));
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<String> findEmailByRun(String run) {
        if (StringUtils.isBlank(run)) return Optional.empty();
        try {
            String url = buildUrlWithPath(transversalesUrl, BUSCAR_EMAIL_PATH) + "?params=" + URLEncoder.encode(run, StandardCharsets.UTF_8);
            String body = webClient.get().uri(url).retrieve().bodyToMono(String.class).block();
            if (body == null) return Optional.empty();
            JsonNode root = objectMapper.readTree(body);
            if (root.isArray() && root.size() > 0) {
                JsonNode f = root.get(0);
                String e = firstNonBlank(
                        text(f, "email"),
                        text(f, "IDEEMAIL"),
                        text(f, "correo"),
                        text(f, "mail")
                );
                if (StringUtils.isNotBlank(e)) return Optional.of(e);
            }
            if (root.isObject()) {
                String e = firstNonBlank(
                        text(root, "email"),
                        text(root, "IDEEMAIL"),
                        text(root, "correo"),
                        text(root, "mail")
                );
                if (StringUtils.isNotBlank(e)) return Optional.of(e);
            }
            String trimmed = body.trim();
            if (trimmed.contains("@")) return Optional.of(trimmed);
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String buildUrlWithPath(String configured, String path) {
        if (configured == null) configured = "";
        if (configured.contains(path)) return configured;
        String base = configured.endsWith("/") ? configured.substring(0, configured.length() - 1) : configured;
        return base + path;
    }

    private String text(JsonNode n, String f) {
        if (n == null || n.get(f) == null || n.get(f).isNull()) return null;
        String s = n.get(f).asText();
        return StringUtils.isBlank(s) ? null : s.trim();
    }

    private String firstNonBlank(String... vals) {
        if (vals == null) return null;
        for (String v : vals) {
            if (StringUtils.isNotBlank(v)) return v;
        }
        return null;
    }

    @Data
    @AllArgsConstructor
    public static class PersonInfo {
        private String nombres;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String email;
    }
}