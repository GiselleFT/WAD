package escom.ttb020.gestionescolar.alumno.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.AlumnoGrupoBs;
import escom.ttb020.gestionescolar.bs.GrupoBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.Grupo;
import escom.ttb020.gestionescolar.mapeo.Profesor;
import escom.ttb020.util.SesionController;
/*Action que permite al usuario Alumno inscribirse a alguno de los grupos existentes*/
@Namespace("/alumno")
@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "gestionar-bienvenida"}) })
@AllowedMethods("buscarGrupo")
public class InscribirGrupoAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8613608785268058279L;

	/**
	 * 
	 */
	private GrupoBs grupoBs = new GrupoBs();
	
	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();
	
	/**
	 * 
	 */
	private AlumnoGrupoBs alumnoGrupoBs = new AlumnoGrupoBs();
	
	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();

	/**
	 * 
	 */
	private List<Grupo> listGrupos;
	
	/**
	 * 
	 */
	private List<Profesor> listProfesores;

	/**
	 * 
	 */
	private Integer idProfesorSel;
	
	/**
	 * 
	 */
	private Integer idGrupoSel;
	
	private Integer idProfesorSel_widget;

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String index() {
		if (SesionController.get("action-messages") != null) {
			addActionMessage((String)SesionController.get("action-messages"));
			System.err.println(getActionMessages());
		}
		listProfesores = busquedaBs.findAll(Profesor.class);
		listGrupos = (List<Grupo>) SesionController.get("listGrupos");
		SesionController.delete("listGrupos");
		return "index";
	}

	/**
	 * @return
	 */
	public String buscarGrupo() {
		if (idProfesorSel == -1) {
			System.err.println("error");
			addFieldError("idProfesorSel", "Campo obligatorio");
			return "success";
		}
		System.err.println("Profesor " + idProfesorSel);
		listGrupos = grupoBs.obtenerGruposByProfesor(idProfesorSel);
		SesionController.put("listGrupos", listGrupos);
		return "index";
	}
	
	/**
	 * @return
	 */
	public String create() {
		Usuario usuario = (Usuario) SesionController.get("session_user");
		Alumno alumno = alumnoBs.obtenerAlumnoByUser(usuario.getId());
		alumnoGrupoBs.registrarAlumnoGrupo(idGrupoSel, alumno.getId());
		SesionController.put("action-messages", "Te has inscrito al grupo exitosamente");
		return "success";
	}

	public List<Grupo> getListGrupos() {
		return listGrupos;
	}

	public void setListGrupos(List<Grupo> listGrupos) {
		this.listGrupos = listGrupos;
	}

	public List<Profesor> getListProfesores() {
		return listProfesores;
	}

	public void setListProfesores(List<Profesor> listProfesores) {
		this.listProfesores = listProfesores;
	}

	public Integer getIdProfesorSel() {
		return idProfesorSel;
	}

	public void setIdProfesorSel(Integer idProfesorSel) {
		this.idProfesorSel = idProfesorSel;
	}

	public Integer getIdGrupoSel() {
		return idGrupoSel;
	}

	public void setIdGrupoSel(Integer idGrupoSel) {
		this.idGrupoSel = idGrupoSel;
	}

	public Integer getIdProfesorSel_widget() {
		return idProfesorSel_widget;
	}

	public void setIdProfesorSel_widget(Integer idProfesorSel_widget) {
		this.idProfesorSel_widget = idProfesorSel_widget;
	}
	
	

}
