package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class SinoTipo implements Serializable{
	
	private boolean bool;
	private String code;
	private String valor;
	
	public SinoTipo(boolean si)
	{
		bool = si;
		if (si)
		{
			code = "S";
			valor = "Sí";
		}
		else
		{
			code = "N";
			valor = "No";
		}
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}	
	
	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}


	public static List<SinoTipo> list=null;
	
	static {
		list = new ArrayList<SinoTipo>();
		list.add(new SinoTipo(true));
		list.add(new SinoTipo(false));		
	}
	
	

}
