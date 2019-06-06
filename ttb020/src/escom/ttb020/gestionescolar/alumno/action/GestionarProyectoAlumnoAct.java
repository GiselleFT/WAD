package escom.ttb020.gestionescolar.alumno.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import escom.ttb020.gestionescolar.bs.GrupoBs;
import escom.ttb020.gestionescolar.bs.ProyectoBs;
import escom.ttb020.gestionescolar.mapeo.Grupo;
import escom.ttb020.gestionescolar.mapeo.Proyecto;
import escom.ttb020.util.SesionController;
/*Action que permite la creaci�n de nuevos proyectos para el usuario de tipo Alumno*/
@Namespace("/alumno")
@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName",
		"../alumno/gestionar-bienvenida" }) })
public class GestionarProyectoAlumnoAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3629438836512701058L;

	/**
	 * 
	 */
	private GrupoBs grupoBs = new GrupoBs();

	/**
	 * 
	 */
	private ProyectoBs proyectoBs = new ProyectoBs();

	/**
	 * 
	 */
	private Integer idAlumno;

	/**
	 * 
	 */
	private List<Grupo> listGrupo;

	/**
	 * 
	 */
	private Proyecto model;

	/**
	 * @return
	 */
	public String index() {
		System.err.println(getActionMessages());
		return "index";
	}

	/**
	 * @return
	 */
	public void validateCreate() {
		if (!hasErrors()) {
			proyectoBs.registrarProyecto(model, idAlumno);
		} else {
			listGrupo = grupoBs.obtenerGruposByAlumno(idAlumno);
		}
	}

	/**
	 * @return
	 */
	public String create() {
		addActionMessage("El proyecto " + model.getNombre() + " se resgitró exitosamente");
		SesionController.put("action-messages", "El proyecto " + model.getNombre() + "se resgitró exitosamente");
		return "success";
	}

	/**
	 * @return
	 */
	public String editNew() {
		listGrupo = grupoBs.obtenerGruposByAlumno(idAlumno);
		return "editNew";
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public List<Grupo> getListGrupo() {
		return listGrupo;
	}

	public void setListGrupo(List<Grupo> listGrupo) {
		this.listGrupo = listGrupo;
	}

	@VisitorFieldValidator
	public Proyecto getModel() {
		return model;
	}

	public void setModel(Proyecto model) {
		this.model = model;
	}

}
