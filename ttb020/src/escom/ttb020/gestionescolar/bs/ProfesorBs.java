package escom.ttb020.gestionescolar.bs;

import java.util.List;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.Profesor;

@Scoped(Scope.SINGLETON)
public class ProfesorBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();
	
	/**
	 * Objeto para busquedas genericas
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * 
	 * Metodo que registra un profesor en base de datos
	 * @param profesor
	 * @param idUser
	 * @return
	 */
	public Profesor registrarProfesor(Profesor profesor, Integer idUser) {
		profesor.setIdUser(idUser);
		return capaModelo.save(profesor);
	}
	
	/**
	 * Obtiene un profesor a partir de un Id de usuario
	 * @param idUser
	 * @return
	 */
	public Profesor obtenerProfesorByUser(Integer idUser) {
		Profesor profesor = new Profesor();
		profesor.setIdUser(idUser);
		List<Profesor> listProfesores = busquedaBs.findByExample(profesor);
		if(!listProfesores.isEmpty()) {
			return listProfesores.get(0);
		}else {
			return null;
		}
	}
}
