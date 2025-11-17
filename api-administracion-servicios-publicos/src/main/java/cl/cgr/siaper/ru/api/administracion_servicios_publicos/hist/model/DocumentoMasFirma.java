package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import es.guadaltel.framework.core.Document;


// Generated 07-jul-2017 9:24:32 by Hibernate Tools 3.4.0.CR1
public class DocumentoMasFirma{
	private Document document ;
	private Documento documento;
	public DocumentoMasFirma(){
		
	}
	public DocumentoMasFirma(Document document ,Documento documento){
		this.document = document;
		this.documento = documento;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
}