package escom.ttb020.gestionescolar.bs;

import java.io.Serializable;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.AlumnoGrupo;

@Scoped(Scope.SINGLETON)
public class AlumnoGrupoBs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3816170767608431961L;
	
	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	
	/**
	 * @param idGrupo
	 * @param idAlumno
	 */
	public void registrarAlumnoGrupo(Integer idGrupo, Integer idAlumno) {
		AlumnoGrupo alumnoGrupo = new AlumnoGrupo(idGrupo, idAlumno);
		capaModelo.save(alumnoGrupo);
	}

}
