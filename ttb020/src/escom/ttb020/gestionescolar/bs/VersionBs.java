package escom.ttb020.gestionescolar.bs;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.Version;
import escom.ttb020.util.SortByDate;

@Scoped(Scope.SINGLETON)
public class VersionBs {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * Objeto para busquedas genericas
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * Obtiene todas las versiones de un diagrama
	 * 
	 * @param idDiagrama
	 * @return
	 */
	public List<Version> obtenerVersionesByDiagrama(Integer idDiagrama) {
		List<Version> listVersiones = busquedaBs.findByExample(new Version(idDiagrama));
		Collections.sort(listVersiones, new SortByDate());
		return listVersiones;
	}

	/**
	 * Registra una version de un diagrama
	 * 
	 * @param model
	 * @return
	 */
	public Version registrarVersion(Integer idDiagrama, Integer idAlumno, String data) {
		Date date = new Date();
		System.err.println(date);
		Version model = new Version();
		model.setIdAlumno(idAlumno);
		model.setIdDiagrama(idDiagrama);
		model.setNombre(date);
		model.setEstatus(false);
		model.setData(data);
		return capaModelo.save(model);
	}

	/**
	 * Actualiza la versión serializada de un diagrama
	 * 
	 * @param idAlumno
	 * @param data
	 * @param model
	 * @return
	 */
	public Version actualizarData(Integer idAlumno, String data, Version model) {
		model.setIdAlumno(idAlumno);
		model.setData(data);
		model.setNombre(new Date());
		return capaModelo.update(model);
	}

	/**
	 * Obtiene la ultima version hecha por un colaborador
	 * 
	 * @param idDiagrama
	 * @return
	 */
	public Version ObtenerUltimaVersion(Integer idDiagrama) {
		List<Version> listVersiones = busquedaBs.findByExample(new Version(idDiagrama));
		Collections.sort(listVersiones, new SortByDate());
		for (Version version : listVersiones) {
			System.err.println(version.getNombre());
		}
		if (!listVersiones.isEmpty()) {
			return listVersiones.get(listVersiones.size() - 1);
		} else {
			return new Version();
		}
	}

}
