package escom.ttb020.gestionescolar.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.gestionescolar.action.views.ProyectoColaboradoresView;
import escom.ttb020.gestionescolar.bs.ProyectoBs;
import escom.ttb020.gestionescolar.mapeo.Grupo;
import escom.ttb020.util.AjaxResult;
import escom.ttb020.util.AjaxResult.EnumRespuestaAjax;
import escom.ttb020.util.SesionController;

@Namespace("/profesor")
@Results({ @Result(name = "prueba", type = "json", params = { "root", "action", "includeProperties",
		"ajaxResult.*" }) })
@AllowedMethods("pruebaAjax")
public class EvaluarProyectoAct {

	/**
	 * 
	 */
	private Integer idGrupoSel;

	/**
	 * 
	 */
	private Integer idProfesorSel;

	/**
	 * 
	 */
	private Grupo grupoSel;

	/**
	 * 
	 */
	private Integer idSel;

	/**
	 * Objeto para el manejo de peticiones Ajax.
	 */
	private AjaxResult ajaxResult;
	
	private String idRelacionSel;

	/**
	 * 
	 */
	private List<ProyectoColaboradoresView> listProyectoColaborador;

	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * 
	 */
	private ProyectoBs proyectoBs = new ProyectoBs();

	/**
	 * Metodo index
	 * 
	 * @return
	 */
	public String index() {
		listProyectoColaborador = proyectoBs.obtenerProyectoGrupoView(idGrupoSel);
		return "index";
	}

	/**
	 * @return
	 */
	public String pruebaAjax() {
		getAjaxResult();
		System.err.println(idRelacionSel);
		ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
		ajaxResult.addCampo("string", "El trash se la come");
		return "prueba";
	}

	public Integer getIdGrupoSel() {
		return idGrupoSel;
	}

	public void setIdGrupoSel(Integer idGrupoSel) {
		if (idGrupoSel != null) {
			grupoSel = busquedaBs.findById(Grupo.class, idGrupoSel);
		}
		this.idGrupoSel = idGrupoSel;
	}

	/**
	 * @return
	 */
	public Integer getIdProfesorSel() {
		return idProfesorSel;
	}

	/**
	 * @param idProfesorSel
	 */
	public void setIdProfesorSel(Integer idProfesorSel) {
		this.idProfesorSel = idProfesorSel;
	}

	/**
	 * @return
	 */
	public Grupo getGrupoSel() {
		return grupoSel;
	}

	/**
	 * @param grupoSel
	 */
	public void setGrupoSel(Grupo grupoSel) {
		this.grupoSel = grupoSel;
	}

	/**
	 * @return
	 */
	public Integer getIdSel() {
		return idSel;
	}

	/**
	 * @param idSel
	 */
	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}

	public List<ProyectoColaboradoresView> getListProyectoColaborador() {
		return listProyectoColaborador;
	}

	public void setListProyectoColaborador(List<ProyectoColaboradoresView> listProyectoColaborador) {
		this.listProyectoColaborador = listProyectoColaborador;
	}

	/**
	 * @return the ajaxResult
	 */
	@JSON(name = "ajaxResult")
	public AjaxResult getAjaxResult() {
		this.ajaxResult = (AjaxResult) SesionController.get("ajaxResult");
		if (ajaxResult == null) {
			ajaxResult = new AjaxResult();
			SesionController.put("ajaxResult", ajaxResult);
		}
		return ajaxResult;
	}

	/**
	 * @param ajaxResult the ajaxResult to set
	 */
	public void setAjaxResult(AjaxResult ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

	public String getIdRelacionSel() {
		return idRelacionSel;
	}

	public void setIdRelacionSel(String idRelacionSel) {
		this.idRelacionSel = idRelacionSel;
	}

}