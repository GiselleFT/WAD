package escom.ttb020.gestionescolar.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.gestionescolar.bs.VersionBs;
import escom.ttb020.gestionescolar.mapeo.Diagrama;
import escom.ttb020.gestionescolar.mapeo.Version;

/**
 * @author edson
 *
 */
@Namespace("/diagrama")
public class GestionarVersionAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3671724065921094435L;
	
	/**
	 * 
	 */
	private VersionBs versionBs = new VersionBs();
	
	private BusquedaBs busquedaBs = new BusquedaBs();
	
	/**
	 * 
	 */
	private List<Version> listVersiones;
	
	/**
	 * 
	 */
	private Integer idDiagramaSel;
	
	/**
	 * 
	 */
	private Diagrama diagramaSel;
	
	
	
	/**
	 * @return
	 */
	public String index() {
		listVersiones = versionBs.obtenerVersionesByDiagrama(idDiagramaSel);
		diagramaSel = busquedaBs.findById(Diagrama.class, idDiagramaSel);
		return "index";
	}

	public List<Version> getListVersiones() {
		return listVersiones;
	}

	public void setListVersiones(List<Version> listVersiones) {
		this.listVersiones = listVersiones;
	}

	public Integer getIdDiagramaSel() {
		return idDiagramaSel;
	}

	public void setIdDiagramaSel(Integer idDiagramaSel) {
		this.idDiagramaSel = idDiagramaSel;
	}

	public Diagrama getDiagramaSel() {
		return diagramaSel;
	}

	public void setDiagramaSel(Diagrama diagramaSel) {
		this.diagramaSel = diagramaSel;
	}

}
