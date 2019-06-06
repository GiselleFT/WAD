package escom.ttb020.gestionescolar.alumno.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.ProyectoBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.Proyecto;
import escom.ttb020.util.SesionController;
/*Action de bienvenida al usuario Alumno, es decir cuando el login fue exitoso*/
@Namespace("/alumno")
public class GestionarBienvenidaAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1391214763860268131L;

	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();

	/**
	 * 
	 */
	private ProyectoBs proyectoBs = new ProyectoBs();

	/**
	 * 
	 */
	private Alumno alumno;

	/**
	 * 
	 */
	private List<Proyecto> listProyectos;

	/**
	 * @return
	 */
	public String index() {
		if (SesionController.get("action-messages") != null) {
			addActionMessage((String)SesionController.get("action-messages"));
			SesionController.delete("action-messages");
			System.err.println(getActionMessages());
		}
		Usuario usuario = (Usuario) SesionController.get("session_user");
		alumno = alumnoBs.obtenerAlumnoByUser(usuario.getId());
		listProyectos = proyectoBs.obtenerProyectosByAlumno(alumno.getId());
		return "index";
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Proyecto> getListProyectos() {
		return listProyectos;
	}

	public void setListProyectos(List<Proyecto> listProyectos) {
		this.listProyectos = listProyectos;
	}

}
