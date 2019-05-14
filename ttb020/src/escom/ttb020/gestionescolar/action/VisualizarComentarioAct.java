package escom.ttb020.gestionescolar.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.gestionescolar.mapeo.Comentario;
import escom.ttb020.gestionescolar.mapeo.Diagrama;

/**
 * @author edson
 *
 */
@Namespace("/diagrama")
public class VisualizarComentarioAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6700684463619031368L;
	
	/**
	 * 
	 */
	private Integer idDiagrama;
	
	private Integer idProyecto;
	
	/**
	 * 
	 */
	private List<Comentario> listCometarios;
	
	private Diagrama diagramaSel;
	
	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();
	
	/**
	 * @return
	 */
	public String index() {
		listCometarios = busquedaBs.findByExample(new Comentario(idDiagrama));
		diagramaSel = busquedaBs.findById(Diagrama.class, idDiagrama);
		return "index";
	}

	public Integer getIdDiagrama() {
		return idDiagrama;
	}

	public void setIdDiagrama(Integer idDiagrama) {
		this.idDiagrama = idDiagrama;
	}

	public List<Comentario> getListCometarios() {
		return listCometarios;
	}

	public void setListCometarios(List<Comentario> listCometarios) {
		this.listCometarios = listCometarios;
	}

	public Diagrama getDiagramaSel() {
		return diagramaSel;
	}

	public void setDiagramaSel(Diagrama diagramaSel) {
		this.diagramaSel = diagramaSel;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

}
