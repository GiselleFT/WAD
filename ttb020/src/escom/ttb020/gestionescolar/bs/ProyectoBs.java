package escom.ttb020.gestionescolar.bs;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.action.views.ProyectoColaboradoresView;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.AlumnoProyecto;
import escom.ttb020.gestionescolar.mapeo.Proyecto;

@Scoped(Scope.SINGLETON)
public class ProyectoBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * Objeto para busquedas genericas
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();
	
	/**
	 * Objeto con el negocio de la entidad AlumnoProyecto
	 */
	private AlumnoProyectoBs alumnoProyectoBs = new AlumnoProyectoBs();

	/**
	 * Metodo que obtiene una lista con los proyectos asociados a un grupo y los
	 * alumnos que colaboraron para mostrar en la pantalla de evaluación de
	 * proyectos
	 * 
	 * @return
	 */
	public List<ProyectoColaboradoresView> obtenerProyectoGrupoView(Integer idGrupo) {
		List<ProyectoColaboradoresView> listProyectosColaboradores = new ArrayList<ProyectoColaboradoresView>();
		List<Proyecto> listProyectos = busquedaBs.findByExample(new Proyecto(idGrupo));
		List<Alumno> listAlumnosColaboradores;
		List<AlumnoProyecto> listAlumnoProyecto;
		for (Proyecto proyecto : listProyectos) {
			listAlumnosColaboradores = new ArrayList<Alumno>();
			listAlumnoProyecto = busquedaBs.findByExample(new AlumnoProyecto(null, proyecto.getId()));
			for (AlumnoProyecto alumnoProyecto : listAlumnoProyecto) {
				listAlumnosColaboradores.add(busquedaBs.findById(Alumno.class, alumnoProyecto.getIdAlumno()));
			}
			listProyectosColaboradores.add(new ProyectoColaboradoresView(proyecto, listAlumnosColaboradores));
		}
		return listProyectosColaboradores;
	}

	/**
	 * Obtiene los pryectos asociados a un grupo
	 * 
	 * @param idAlumno
	 * @return
	 */
	public List<Proyecto> obtenerProyectosByAlumno(Integer idAlumno) {
		List<AlumnoProyecto> listAlumnoProyecto = busquedaBs.findByExample(new AlumnoProyecto(idAlumno, null));
		List<Proyecto> listProyectos = new ArrayList<Proyecto>();
		Proyecto proyecto;
		for (AlumnoProyecto alumnoProyecto : listAlumnoProyecto) {
			proyecto = busquedaBs.findById(Proyecto.class, alumnoProyecto.getIdProyecto());
			listProyectos.add(proyecto);
		}
		return listProyectos;
	}
	
	/**
	 * Registra un proyecto de un alumno asocioado a un grupo
	 * 
	 * @param model
	 * @return
	 */
	@Transactional(rollbackOn = Exception.class)
	public void registrarProyecto(Proyecto model, Integer idAlumno) {
		 capaModelo.save(model);
		 alumnoProyectoBs.registrarAlumnoProyecto(idAlumno, model.getId());
	}
}
