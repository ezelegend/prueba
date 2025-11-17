package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.utils;

import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

//import org.jboss.seam.ScopeType;
//import org.jboss.seam.annotations.AutoCreate;
//import org.jboss.seam.annotations.Name;
//import org.jboss.seam.annotations.Scope;

//@Name("validacionBean")
//@Scope(ScopeType.APPLICATION)
//@AutoCreate
@Component
public class ValidacionBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620241786169601029L;

	public void validarRut(
//			FacesContext context,
//			UIComponent component,
			Object value) {

		String rut = value == null ? "" : ((String) value).toUpperCase();
		String[] sRut = rut.split("-");

		if (sRut.length != 2 || sRut[1].length() != 1) {
			throw new ValidatorException(new FacesMessage("error.invalidRut"));
		}
		
		int t = 0;
		try {
			t = Integer.parseInt(sRut[0]);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage("error.invalidRut"));
		}
		
		
		int m = 0, s = 1;
		for (; t != 0; t /= 10)
			s = (s + t % 10 * (9 - m++ % 6)) % 11;
		char v = (char) (s != 0 ? s + 47 : 75);

		if (!String.valueOf(v).equals(sRut[1])) {
			throw new ValidatorException(new FacesMessage("error.invalidRut"));
		}

	}

}