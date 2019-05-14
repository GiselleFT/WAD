package escom.ttb020.gestionescolar.bs;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.AlumnoGrupo;
import escom.ttb020.gestionescolar.mapeo.AlumnoProyecto;

@Scoped(Scope.SINGLETON)
public class AlumnoBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * Registrar alumno en base de datos
	 * 
	 * @param alumno
	 * @param idUser
	 * @return
	 */
	public Alumno registrarAlumno(Alumno alumno, Integer idUser) {
		alumno.setIdUser(idUser);
		return capaModelo.save(alumno);
	}

	/**
	 * Obtiene los alumnos de un grupo a partir de una lista de objetos de
	 * {@link}AlumnoGrupo
	 * 
	 * @return
	 */
	public List<Alumno> obtenerAlumnosporGrupo(List<AlumnoGrupo> listAlumnoGrupo) {
		List<Alumno> listAlumnos = new ArrayList<Alumno>();
		Alumno alumno;
		for (AlumnoGrupo alumnoGrupo : listAlumnoGrupo) {
			alumno = new Alumno();
			alumno = busquedaBs.findById(Alumno.class, alumnoGrupo.getIdAlumno());
			listAlumnos.add(alumno);
		}
		return listAlumnos;
	}

	/**
	 * Obtiene los alumnos que colaboran en un proyecto
	 * 
	 * @param idProyecto
	 * @return
	 */
	public List<Alumno> obtenerAlumnosColaboradores(Integer idProyecto) {
		List<Alumno> listAlumnosColaboradores = new ArrayList<Alumno>();
		List<AlumnoProyecto> listAlumnoProyecto = busquedaBs.findByExample(new AlumnoProyecto(null, idProyecto));
		for (AlumnoProyecto alumnoProyecto : listAlumnoProyecto) {
			listAlumnosColaboradores.add(busquedaBs.findById(Alumno.class, alumnoProyecto.getIdAlumno()));
		}
		return listAlumnosColaboradores;
	}

	/**
	 * Obtiene el alumno a partir del id de usuario
	 * 
	 * @param idUser
	 * @return
	 */
	public Alumno obtenerAlumnoByUser(Integer idUser) {
		Alumno alumno = new Alumno();
		alumno.setIdUser(idUser);
		List<Alumno> listAlumnos = busquedaBs.findByExample(alumno);
		if (!listAlumnos.isEmpty()) {
			return listAlumnos.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Obtiene los alumnos de un grupo a partir de una lista de objetos de
	 * {@link}AlumnoGrupo y retira de la lista al alumno en sesion
	 * 
	 * @return
	 */
	public List<Alumno> obtenerAlumnosporGrupoSinActual(List<AlumnoGrupo> listAlumnoGrupo,
			List<Alumno> alumnosColaboradores) {
		List<Alumno> listAlumnos = new ArrayList<Alumno>();
		Alumno alumno;
		for (AlumnoGrupo alumnoGrupo : listAlumnoGrupo) {
				if (estaAlumno(alumnoGrupo.getIdAlumno(), alumnosColaboradores)) {
					alumno = new Alumno();
					alumno = busquedaBs.findById(Alumno.class, alumnoGrupo.getIdAlumno());
					listAlumnos.add(alumno);
				}
		}
		return listAlumnos;
	}
	
	/**
	 * @param idAlumno
	 * @param alumnosColaboradores
	 * @return
	 */
	private Boolean estaAlumno(Integer idAlumno, List<Alumno> alumnosColaboradores) {
		for (Alumno alumnoCol : alumnosColaboradores) {
			if(alumnoCol.getId() == idAlumno) {
				return false;
			}
		}
		
		return true;
	}

}
