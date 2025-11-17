package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.invoker;

import java.io.Serializable;
import java.util.List;

public class InvokerResponse implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -3380582294301599720L;

    private Long time;

    private String string;

    private List<String[]> stringList;

    private byte[] bytes;

    private Status status;

    private MessageType messageType;

    private InvokerException exception;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<String[]> getStringList() {
        return stringList;
    }

    public void setStringList(List<String[]> stringList) {
        this.stringList = stringList;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public InvokerException getException() {
        return exception;
    }

    public void setException(InvokerException exception) {
        this.exception = exception;
    }
}