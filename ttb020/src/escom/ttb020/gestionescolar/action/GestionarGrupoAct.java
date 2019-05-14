package escom.ttb020.gestionescolar.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.GrupoBs;
import escom.ttb020.gestionescolar.bs.ProfesorBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.AlumnoGrupo;
import escom.ttb020.gestionescolar.mapeo.Grupo;
import escom.ttb020.gestionescolar.mapeo.Profesor;
import escom.ttb020.util.SesionController;

@Namespace("/profesor")
@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "gestionar-grupo" }) })
public class GestionarGrupoAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019606266334677088L;

	/**
	 * Objeto de capa de negocio de profesor
	 */
	private ProfesorBs profesorBs = new ProfesorBs();

	/**
	 * 
	 */
	private GrupoBs grupoBs = new GrupoBs();

	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();

	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * Profesor de la sesion
	 */
	private Profesor profesor;

	/**
	 * 
	 */
	private List<Grupo> listGrupos;

	/**
	 * 
	 */
	private List<Alumno> listAlumnos;

	/**
	 * 
	 */
	private Integer idProfesorSel;

	/**
	 * 
	 */
	private Grupo model;

	/**
	 * 
	 */
	private Integer idSel;

	/**
	 * metodo que redirecciona al jsp index
	 * 
	 * @return
	 */
	public String index() {
		Usuario usuario = (Usuario) SesionController.get("session_user");
		profesor = profesorBs.obtenerProfesorByUser(usuario.getId());
		listGrupos = busquedaBs.findByExample(new Grupo(profesor.getId()));
		return "index";
	}

	/**
	 * Pantalla crear grupo
	 * 
	 * @return
	 */
	public String editNew() {
		return "editNew";
	}

	/**
	 * 
	 */
	public void validateCreate() {
		grupoBs.registrarGrupo(model, idProfesorSel);
	}

	/**
	 * @return
	 */
	public String create() {
		addActionMessage("El grupo " + model.getNombre() + " registrado exitosamente");
		System.err.println("Grupo registrado");
		return "success";
	}

	/**
	 * Pantalla visualizar Alumnos inscritos
	 * 
	 * @return
	 */
	public String show() {
		System.err.println("Grupo " + idSel);
		List<AlumnoGrupo> listAlumnosGrupo = busquedaBs.findByExample(new AlumnoGrupo(idSel, null));
		listAlumnos = alumnoBs.obtenerAlumnosporGrupo(listAlumnosGrupo);
		return "show";
	}

	/**
	 * @return
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return
	 */
	public List<Grupo> getListGrupos() {
		return listGrupos;
	}

	/**
	 * @param listGrupos
	 */
	public void setListGrupos(List<Grupo> listGrupos) {
		this.listGrupos = listGrupos;
	}

	public Integer getIdProfesorSel() {
		return idProfesorSel;
	}

	public void setIdProfesorSel(Integer idProfesorSel) {
		this.idProfesorSel = idProfesorSel;
	}

	public Grupo getModel() {
		return model;
	}

	public void setModel(Grupo model) {
		this.model = model;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		if (idSel != null) {
			model = busquedaBs.findById(Grupo.class, idSel);
		}
		this.idSel = idSel;
	}

	public List<Alumno> getListAlumnos() {
		return listAlumnos;
	}

	public void setListAlumnos(List<Alumno> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}

}
