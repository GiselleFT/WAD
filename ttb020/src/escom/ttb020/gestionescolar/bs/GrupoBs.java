package escom.ttb020.gestionescolar.bs;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.AlumnoGrupo;
import escom.ttb020.gestionescolar.mapeo.Grupo;

@Scoped(Scope.SINGLETON)
public class GrupoBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * Registra un grupo en base de datos
	 * 
	 * @param model
	 * @param idProfesor
	 * @return
	 */
	public Grupo registrarGrupo(Grupo model, Integer idProfesor) {
		model.setIdProfesor(idProfesor);
		return capaModelo.save(model);
	}

	/**
	 * Método que obtiene los grupos asociados a un alumno
	 * 
	 * @param idAlumno
	 * @return
	 */
	public List<Grupo> obtenerGruposByAlumno(Integer idAlumno) {
		List<AlumnoGrupo> listAlumnoGrupo = busquedaBs.findByExample(new AlumnoGrupo(null, idAlumno));
		List<Grupo> listGrupos = new ArrayList<Grupo>();
		for (AlumnoGrupo alumnoGrupo : listAlumnoGrupo) {
			listGrupos.add(busquedaBs.findById(Grupo.class, alumnoGrupo.getIdGrupo()));
		}

		return listGrupos;
	}

	/**
	 * Método que obtiene los grupos de un profesor
	 * 
	 * @param idProfesor
	 * @return
	 */
	public List<Grupo> obtenerGruposByProfesor(Integer idProfesor) {
		return busquedaBs.findByExample(new Grupo(idProfesor));
	}
	
	public boolean eliminarGrupo(Integer idGrupo){
		List<Grupo> gruposProfesor = obtenerGruposByProfesor(1);
		Grupo grupoEliminar = gruposProfesor.get(idGrupo);
		capaModelo.delete(grupoEliminar);
		return true;
	}
	
	
	

}
