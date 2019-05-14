package escom.ttb020.gestionescolar.bs;

import java.io.Serializable;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.Diagrama;
import escom.ttb020.gestionescolar.mapeo.TipoDiagrama.TipoDiagramaEnum;

@Scoped(Scope.SINGLETON)
public class DiagramaBs implements Serializable {

	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * 
	 */
	private static final long serialVersionUID = -4890166083654244737L;

	/**
	 * Registra un diagrama en la base de datos
	 * 
	 * @param model
	 */
	public Diagrama regitrarDiagramaCu(Diagrama model) {
		model.setIdTipo(TipoDiagramaEnum.CU.getValor());
		model.setEstado(1);
		model.setData(null);
		return capaModelo.save(model);
	}
	
	/**
	 * Registra un diagrama de clases en la base de datos
	 * @param model
	 * @return
	 */
	public Diagrama regitrarDiagramaClases(Diagrama model) {
		model.setIdTipo(TipoDiagramaEnum.CLASES.getValor());
		model.setEstado(1);
		model.setData(null);
		return capaModelo.save(model);
	}

	/**
	 * 
	 * Actualiza la cadena que contiene la serialización del diagrama
	 * 
	 * @param model
	 * @param data
	 * @return
	 */
	public Diagrama actualizarData(Diagrama model, String data) {
		model.setData(data);
		return capaModelo.update(model);
	}

}
