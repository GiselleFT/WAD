package escom.ttb020.gestionescolar.bs;

import javax.transaction.Transactional;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.AlumnoProyecto;

@Scoped(Scope.SINGLETON)
public class AlumnoProyectoBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * 
	 */
	@Transactional(rollbackOn = Exception.class)
	public void registrarAlumnoProyecto(Integer idAlumno, Integer idProyecto) {
		AlumnoProyecto alumnoProyecto = new AlumnoProyecto(idAlumno, idProyecto);
		capaModelo.save(alumnoProyecto);
	}
}
