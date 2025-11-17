package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker;

import jakarta.jms.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.UUID;

@Configuration
public class InvokerConfig {

    @Bean
    @Primary
    public Invoker invokerBean() {
        return new MockInvoker();
    }

    static class MockInvoker implements Invoker {

        @Override
        public InvokerResponse invoke(String serviceId, String... params) throws InvokerException {
            InvokerResponse r = new InvokerResponse();
            r.setStatus(Status.COMPLETE);
            r.setStringList(Collections.emptyList());
            return r;
        }

        @Override
        public String invokeAsync(String serviceId, String... params) throws InvokerException {
            return UUID.randomUUID().toString();
        }

        @Override
        public InvokerResponse getResponse(String id) throws InvokerException {
            InvokerResponse r = new InvokerResponse();
            r.setStatus(Status.COMPLETE);
            r.setStringList(Collections.emptyList());
            return r;
        }

        @Override
        public void onMessage(Message message) {
            // No-op
        }
    }
}