package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GrillaObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4844831155967311364L;

	String planta;

	String xPlanta;

	List<Dotacion> listRegPlantaServ;

	private String floorAnte;
	
	public GrillaObject() {

	}

	public GrillaObject(String planta, String xPlanta, List<Dotacion> listRegPlantaServ) {
		this.planta = planta;
		this.xPlanta = xPlanta;
		this.listRegPlantaServ = listRegPlantaServ;
	}

	public List<GrillaObject> getListGrillaObjectToTraRegPlantServ(List<Dotacion> list) {
		List<GrillaObject> returnList = new ArrayList<GrillaObject>();
		floorAnte = "";
		for (Dotacion rps : list) {
			if (rps.getPlantaServicio().getPlanta() != null && rps.getPlantaServicio().getPlanta().getCodSiaper() != -1) {
				String floor = rps.getPlantaServicio().getPlanta().getDescripcion();
				String xPla = Long.toString(rps.getPlantaServicio().getId());
				if (floorAnte != floor) {
					floorAnte = floor;
					returnList.add(new GrillaObject(floor, xPla, getListForFloor(rps.getPlantaServicio().getPlanta().getCodSiaper(), list)));
				}
			}
		}
		return returnList;
	}

	private List<Dotacion> getListForFloor(Long floor, List<Dotacion> list) {
		List<Dotacion> returnList = new ArrayList<Dotacion>();
		for (Dotacion rps : list) {
			if (floor == rps.getPlantaServicio().getPlanta().getCodSiaper()) {
				returnList.add(rps);
			}
		}
		return returnList;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public List<Dotacion> getListRegPlantaServ() {
		return listRegPlantaServ;
	}

	public void setListRegPlantaServ(List<Dotacion> listRegPlantaServ) {
		this.listRegPlantaServ = listRegPlantaServ;
	}

	public String getxPlanta() {
		return xPlanta;
	}

	public void setxPlanta(String xPlanta) {
		this.xPlanta = xPlanta;
	}

}
