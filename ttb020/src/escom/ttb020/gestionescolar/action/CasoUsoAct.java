package escom.ttb020.gestionescolar.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;

import escom.ttb020.bs.IA.AgenteAjax;
import escom.ttb020.bs.IA.Relation;
import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.ComentarioBs;
import escom.ttb020.gestionescolar.bs.VersionBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.Diagrama;
import escom.ttb020.gestionescolar.mapeo.Version;
import escom.ttb020.util.AjaxResult;
import escom.ttb020.util.AjaxResult.EnumRespuestaAjax;
import escom.ttb020.util.SesionController;

@Namespace("/diagrama")
@Results({ @Result(name = "prueba", type = "json", params = { "root", "action", "includeProperties", "ajaxResult.*" }),
		@Result(name = "exito", type = "json", params = { "root", "action", "includeProperties", "ajaxResult.*" }),
		@Result(name = "actualizar", type = "json", params = { "root", "action", "includeProperties", "ajaxResult.*" }) })
@AllowedMethods({ "pruebaAjax", "guardarComentario", "registrarDatos", "actualizarData", "editVersion" })
public class CasoUsoAct {

	/**
	 * Objeto para el manejo de peticiones Ajax.
	 */
	private AjaxResult ajaxResult;

	/**
	 * 
	 */
	private AgenteAjax agenteAjax = new AgenteAjax();
	
	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();
	
	/**
	 * 
	 */
	private VersionBs versionBs = new VersionBs();

	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * Identificación de la relación seleccionada en la vista
	 */
	private String idRelacionSel;

	/**
	 * Nombre del primer caso de uso colocado en la vista
	 */
	private String ncu;

	/**
	 * Nombre del segundo caso de uso colocado en la vista
	 */
	private String ncu2;

	/**
	 * 
	 */
	private String texto;
	/**
	 * 
	 */
	private Integer idProyecto;
	/**
	 * 
	 */
	private ComentarioBs comentarioBs = new ComentarioBs();

	/**
	 * 
	 */
	private List<String> listStrongVerbs;

	/**
	 * Id del diagrama seleccionado
	 */
	private Integer idSel;

	/**
	 * 
	 */
	private Diagrama model;

	/**
	 * 
	 */
	private String data;
	
	/**
	 * 
	 */
	private Version version;
	
	/**
	 * 
	 */
	private Integer idVersionSel;

	/**
	 * @return
	 */
	public String index() {
		listStrongVerbs = new ArrayList<String>();
		listStrongVerbs.add("Actualizar");
		listStrongVerbs.add("Gestionar");
		listStrongVerbs.add("Administrar");
		listStrongVerbs.add("Editar");
		listStrongVerbs.add("Realizar");
		listStrongVerbs.add("Agrupar");
		listStrongVerbs.add("Retirar");
		listStrongVerbs.add("Pagar");
		listStrongVerbs.add("Visualizar");
		listStrongVerbs.add("Eliminar");
		listStrongVerbs.add("Borrar");
		listStrongVerbs.add("Agregar");
		listStrongVerbs.add("Añadir");
		listStrongVerbs.add("Adjuntar");
		listStrongVerbs.add("Encender");
		listStrongVerbs.add("Abrir");
		listStrongVerbs.add("Finalizar");
		return "index";
	}
	
	/**
	 * @return
	 */
	public String edit() {
		listStrongVerbs = new ArrayList<String>();
		listStrongVerbs.add("Actualizar");
		listStrongVerbs.add("Gestionar");
		listStrongVerbs.add("Administrar");
		listStrongVerbs.add("Editar");
		listStrongVerbs.add("Realizar");
		listStrongVerbs.add("Agrupar");
		listStrongVerbs.add("Retirar");
		listStrongVerbs.add("Pagar");
		listStrongVerbs.add("Visualizar");
		listStrongVerbs.add("Eliminar");
		listStrongVerbs.add("Borrar");
		listStrongVerbs.add("Agregar");
		listStrongVerbs.add("Añadir");
		listStrongVerbs.add("Adjuntar");
		listStrongVerbs.add("Encender");
		listStrongVerbs.add("Abrir");
		listStrongVerbs.add("Finalizar");
		version = versionBs.ObtenerUltimaVersion(model.getId());
		return "edit";
	}
	
	public String editVersion() {
		listStrongVerbs = new ArrayList<String>();
		listStrongVerbs.add("Actualizar");
		listStrongVerbs.add("Gestionar");
		listStrongVerbs.add("Administrar");
		listStrongVerbs.add("Editar");
		listStrongVerbs.add("Realizar");
		listStrongVerbs.add("Agrupar");
		listStrongVerbs.add("Retirar");
		listStrongVerbs.add("Pagar");
		listStrongVerbs.add("Visualizar");
		listStrongVerbs.add("Eliminar");
		listStrongVerbs.add("Borrar");
		listStrongVerbs.add("Agregar");
		listStrongVerbs.add("Añadir");
		listStrongVerbs.add("Adjuntar");
		listStrongVerbs.add("Encender");
		listStrongVerbs.add("Abrir");
		listStrongVerbs.add("Finalizar");
		version = busquedaBs.findById(Version.class, idVersionSel);
		return "edit";
	}

	/**
	 * @return
	 */
	public String pruebaAjax() {
		getAjaxResult();
		System.err.println(idRelacionSel);
		System.err.println("ncu" + ncu);

		ArrayList<String> data;

		if (idRelacionSel.equalsIgnoreCase("extends")) {
			data = agenteAjax.getData(Relation.EXTEND, ncu);

			if (data == null || data.isEmpty()) {
				ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			} else {
				ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
				ajaxResult.addCampo("data", data);
			}
			System.err.println(ajaxResult.getResponse().get("estatus"));

		} else if (idRelacionSel.equalsIgnoreCase("include")) {
			data = agenteAjax.getData(Relation.INCLUDE, ncu);

			if (data == null || data.isEmpty()) {
				ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			} else {
				ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
				ajaxResult.addCampo("data", data);
			}
			System.err.println(ajaxResult.getResponse().get("estatus"));
		}

		return "prueba";
	}
	
	/**
	 * Metodo para registrar enunciados de casos de uso en 
	 * la base de conocimiento en caso de queestos no sean 
	 * encontrados.
	 * @return
	 */
	public String registrarDatos() {
		getAjaxResult();
		System.out.println("Primer enunciado: " + ncu);
		System.out.println("Tipo relacion: " + idRelacionSel);
		System.out.println("Segundo enunciado: " + ncu2);

		if (agenteAjax.registrarDatos(ncu, idRelacionSel, ncu2)) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos Ok");
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos FAIL");
		}

		return "exito";
	}
	
	/**
	 * Metodo para registrar comentarios del profesor en el 
	 * diagrama.
	 * @return
	 */
	public String guardarComentario() {
		comentarioBs.registrarComentario(texto, idSel);
		getAjaxResult();
		ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
		ajaxResult.addCampo("string", texto);
		return "exito";
	}

	/**
	 * Actualiza el xml de la clase diagrama para
	 * 
	 * @return
	 */
	public String actualizarData() {
		System.err.println("data" + data);
		//diagramaBs.actualizarData(model, data);
		Usuario usuario = (Usuario) SesionController.get("session_user");
		Alumno alumno = alumnoBs.obtenerAlumnoByUser(usuario.getId());
		versionBs.registrarVersion(model.getId(), alumno.getId(), data);
		getAjaxResult();
		ajaxResult.addCampo("actionMessage", "El diagrama se guardo con exito!!");
		return "actualizar";
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

	/**
	 * @return
	 */
	public String getIdRelacionSel() {
		return idRelacionSel;
	}

	/**
	 * @param idRelacionSel
	 */
	public void setIdRelacionSel(String idRelacionSel) {
		this.idRelacionSel = idRelacionSel;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNcu() {
		return ncu;
	}

	public void setNcu(String ncu) {
		this.ncu = ncu;
	}

	public String getNcu2() {
		return ncu2;
	}

	public void setNcu2(String ncu2) {
		this.ncu2 = ncu2;
	}

	public List<String> getListStrongVerbs() {
		return listStrongVerbs;
	}

	public void setListStrongVerbs(List<String> listStrongVerbs) {
		this.listStrongVerbs = listStrongVerbs;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		if (idSel != null) {
			model = busquedaBs.findById(Diagrama.class, idSel);
		}
		this.idSel = idSel;
	}

	public Diagrama getModel() {
		return model;
	}

	public void setModel(Diagrama model) {
		this.model = model;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Integer getIdVersionSel() {
		return idVersionSel;
	}

	public void setIdVersionSel(Integer idVersionSel) {
		this.idVersionSel = idVersionSel;
	}

}
