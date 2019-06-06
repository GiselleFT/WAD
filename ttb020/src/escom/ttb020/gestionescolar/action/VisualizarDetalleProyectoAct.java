package escom.ttb020.gestionescolar.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.AlumnoProyectoBs;
import escom.ttb020.gestionescolar.bs.DiagramaBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.AlumnoGrupo;
import escom.ttb020.gestionescolar.mapeo.Diagrama;
import escom.ttb020.gestionescolar.mapeo.Proyecto;
import escom.ttb020.gestionescolar.mapeo.TipoDiagrama.TipoDiagramaEnum;
import escom.ttb020.util.SesionController;

/*Action que permite visualizar el detalle de los proyectos creados por un usuario*/
@Namespace("/diagrama")
@Results({
		@Result(name = "successDiagrama", type = "redirectAction", params = { "actionName", "caso-uso", "idProyecto",
				"%{idProyecto}", "idSel", "%{idSel}" }),
		@Result(name = "successClases", type = "redirectAction", params = { "actionName", "clases", "idProyecto",
				"%{idProyecto}", "idSel", "%{idSel}" }),
		@Result(name = "success", type = "redirectAction", params = { "actionName", "visualizar-detalle-proyecto",
				"idProyecto", "%{idProyecto}" }) })
@AllowedMethods({ "agregarColaborador", "editNewClases", "crearClases" })
public class VisualizarDetalleProyectoAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774599403352139912L;

	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();

	/**
	 * 
	 */
	private DiagramaBs diagramaBs = new DiagramaBs();

	/**
	 * 
	 */
	private AlumnoProyectoBs alumnoProyectoBs = new AlumnoProyectoBs();

	/**
	 * Objeto para busquedas genericas
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * 
	 */
	private Integer idProyecto;

	/**
	 * 
	 */
	private Integer idSel;

	/**
	 * 
	 */
	private List<Alumno> alumnosColaboradores;

	/**
	 * 
	 */
	private List<Diagrama> listCasos;

	/**
	 * 
	 */
	private List<Diagrama> listClases;

	/**
	 * Proyecto seleccionado
	 */
	private Proyecto proyectoSel;

	/**
	 * 
	 */
	private Diagrama model;

	/**
	 * 
	 */
	private List<Alumno> listPosiblesColaboradores;

	/**
	 * 
	 */
	private Integer idColaboradorSel;

	/**Este método se invoca en peticiones GET
	 * @return
	 */
	public String index() {
		if (SesionController.get("action-messages") != null) {
			addActionMessage((String) SesionController.get("action-messages"));
			SesionController.delete("action-messages");
			System.err.println(getActionMessages());
		}
		listCasos = new ArrayList<Diagrama>();
		listClases = new ArrayList<Diagrama>();
		List<AlumnoGrupo> listAlumnoGrupo = busquedaBs
				.findByExample(new AlumnoGrupo(proyectoSel.getIdGrupo(), null));
		alumnosColaboradores = alumnoBs.obtenerAlumnosColaboradores(idProyecto);
		listPosiblesColaboradores = alumnoBs.obtenerAlumnosporGrupoSinActual(listAlumnoGrupo, alumnosColaboradores);
		for (Diagrama diagrama : proyectoSel.getDiagramas()) {
			if (diagrama.getIdTipo() == TipoDiagramaEnum.CU.getValor()) {
				listCasos.add(diagrama);
			} else if (diagrama.getIdTipo() == TipoDiagramaEnum.CLASES.getValor()) {
				listClases.add(diagrama);
			}
		}
		return "index";
	}

	public String editNew() {
		return "editNew";
	}

	/**
	 * 
	 */
	public void validateCreate() {
		model.setIdProyecto(idProyecto);
		model = diagramaBs.regitrarDiagramaCu(model);
	}

	/**Este método se invoca en peticiones POST
	 * @return
	 */
	public String create() {
		setIdSel(model.getId());
		return "successDiagrama";
	}
	
	/**
	 * @return
	 */
	public String editNewClases() {
		return "editNewClases";
	}

	/**
	 * Metodo para agregar a un colaborador
	 * 
	 * @return
	 */
	@SkipValidation
	public String agregarColaborador() {
		alumnoProyectoBs.registrarAlumnoProyecto(idColaboradorSel, idProyecto);
		SesionController.put("action-messages", "Se agregÃ³ el colaborador exitosamente.");
		addActionMessage("Se agregÃ³ el colaborador exitosamente.");
		return "success";
	}

	/**
	 * @return
	 */
	@SkipValidation
	public String crearClases() {
		model.setIdProyecto(idProyecto);
		model = diagramaBs.regitrarDiagramaClases(model);
		setIdSel(model.getId());
		return "successClases";
	}

	public Proyecto getProyectoSel() {
		return proyectoSel;
	}

	public void setProyectoSel(Proyecto proyectoSel) {
		this.proyectoSel = proyectoSel;
	}

	public List<Alumno> getAlumnosColaboradores() {
		return alumnosColaboradores;
	}

	public void setAlumnosColaboradores(List<Alumno> alumnosColaboradores) {
		this.alumnosColaboradores = alumnosColaboradores;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		if (idProyecto != null) {
			proyectoSel = busquedaBs.findById(Proyecto.class, idProyecto);
		}
		this.idProyecto = idProyecto;
	}

	public Diagrama getModel() {
		return model;
	}

	public void setModel(Diagrama model) {
		this.model = model;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}

	public List<Diagrama> getListCasos() {
		return listCasos;
	}

	public void setListCasos(List<Diagrama> listCasos) {
		this.listCasos = listCasos;
	}

	public List<Diagrama> getListClases() {
		return listClases;
	}

	public void setListClases(List<Diagrama> listClases) {
		this.listClases = listClases;
	}

	public List<Alumno> getListPosiblesColaboradores() {
		return listPosiblesColaboradores;
	}

	public void setListPosiblesColaboradores(List<Alumno> listPosiblesColaboradores) {
		this.listPosiblesColaboradores = listPosiblesColaboradores;
	}

	public Integer getIdColaboradorSel() {
		return idColaboradorSel;
	}

	public void setIdColaboradorSel(Integer idColaboradorSel) {
		this.idColaboradorSel = idColaboradorSel;
	}

}
