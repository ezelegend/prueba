package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker;

import jakarta.jms.MessageListener;

public interface Invoker extends MessageListener {
   
    public InvokerResponse invoke(String serviceId, String... params) throws InvokerException;

    public String invokeAsync(String serviceId, String... params) throws InvokerException;

    public InvokerResponse getResponse(String id) throws InvokerException;
   
}