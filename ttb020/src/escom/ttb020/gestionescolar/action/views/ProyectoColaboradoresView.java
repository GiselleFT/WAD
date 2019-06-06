package escom.ttb020.gestionescolar.action.views;

import java.util.List;

import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.Proyecto;
/*Esta clase contiene los métodos get y set que permiten obtener la lista de alumnos 
 * para proyectos colaborativos*/
public class ProyectoColaboradoresView {

	/**
	 * 
	 */
	private Proyecto proyecto;

	/**
	 * 
	 */
	private List<Alumno> listAlumnos;

	/**
	 * 
	 */
	public ProyectoColaboradoresView() {
		super();
	}
	
	

	public ProyectoColaboradoresView(Proyecto proyecto, List<Alumno> listAlumnos) {
		super();
		this.proyecto = proyecto;
		this.listAlumnos = listAlumnos;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Alumno> getListAlumnos() {
		return listAlumnos;
	}

	public void setListAlumnos(List<Alumno> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}
}
