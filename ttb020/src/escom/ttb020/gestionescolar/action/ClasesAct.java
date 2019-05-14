package escom.ttb020.gestionescolar.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.IA.AgenteAjax;
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

/**
 * @author edson
 *
 */
@Namespace("/diagrama")
@Results({
		@Result(name = "obtMetodos", type = "json", params = { "root", "action", "includeProperties", "ajaxResult.*" }),
		@Result(name = "obtClases", type = "json", params = { "root", "action", "includeProperties", "ajaxResult.*" }),
		@Result(name = "enviarAtributos", type = "json", params = { "root", "action", "includeProperties",
				"ajaxResult.*" }),
		@Result(name = "enviarOperaciones", type = "json", params = { "root", "action", "includeProperties",
				"ajaxResult.*" }) })
@AllowedMethods({ "obtenerClases", "obtenerAtMet", "registrarDatos", "guardarVersion", "editVersion", "enviarAt",
		"enviarOp", "guardarComentario" })
public class ClasesAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3296202564019343820L;

	/**
	 * 
	 */
	private VersionBs versionBs = new VersionBs();

	/**
	 * 
	 */
	private AlumnoBs alumnoBs = new AlumnoBs();

	/**
	 * 
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

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
	private String claseUno;

	/**
	 * 
	 */
	private String claseDos;

	/**
	 * 
	 */
	private String tipoRelacion;

	/**
	 * 
	 */
	private Version version;
	/**
	 * 
	 */
	private String clase;

	/**
	 * 
	 */
	private String atributo;

	/**
	 * 
	 */
	private String metodo;

	/**
	 * 
	 */
	private List<String> listMetodos;

	/**
	 * 
	 */
	private List<String> listAtributos;

	/**
	 * 
	 */
	private List<String> listClases;

	/**
	 * 
	 */
	private Diagrama model;

	/**
	 * 
	 */
	private Integer idSel;

	/**
	 * 
	 */
	private String data;

	/**
	 * 
	 */
	private Integer idVersionSel;
	
	/**
	 * 
	 */
	private String texto;
	
	private ComentarioBs comentarioBs = new ComentarioBs();
	
	private Integer libre;

	/**
	 * Metodo que obtiene los atributos y los envia al ManagerXML
	 * 
	 * @return
	 */
	public String enviarAt() {
		getAjaxResult();
		System.out.println("Clase: " + clase);
		System.out.println("Atributo: " + atributo);

		if (agenteAjax.registrarAtributos(clase, atributo)) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos Ok");
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos FAIL");
		}
		return "enviarAtributos";
	}

	/**
	 * Metodo que obtiene las operaciones y las envia al ManagerXML
	 * 
	 * @return
	 */
	public String enviarOp() {
		getAjaxResult();
		System.out.println("Clase: " + clase);
		System.out.println("Atributo: " + metodo);

		if (agenteAjax.registrarMetodos(clase, metodo)) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos Ok");
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos FAIL");
		}
		return "enviarOperaciones";
	}

	/**
	 * Metodo que obtiene los atributos y metodos al crear una clase
	 * 
	 * @return
	 */
	public String obtenerAtMet() {
		getAjaxResult();
		listMetodos = agenteAjax.obtenerMetodos(claseUno);
		listAtributos = agenteAjax.obtenerAtributos(claseUno);
		if (listClases != null || listAtributos != null) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("dataMetodos", listMetodos);
			ajaxResult.addCampo("dataAtributos", listAtributos);
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
		}
		System.err.println("Nombre de la clase Obtener Metodo: " + claseUno);
		return "obtMetodos";
	}

	/**
	 * Metodo con el se obtienen las clase con las relaciones seleccionada
	 * 
	 * @return
	 */
	public String obtenerClases() {
		getAjaxResult();
		listClases = agenteAjax.obtenerClasesRelacionadas(claseUno, tipoRelacion);
		if (listClases != null) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("data", listClases);
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
		}
		System.err.println("Nombre de la clase: " + claseUno);
		System.err.println("Nombre de la relación: " + tipoRelacion);
		return "obtClases";
	}

	/**
	 * Metodo que registra relaciones no encontradas en el XML
	 * 
	 * @return
	 */
	public String registrarDatos() {
		getAjaxResult();
		System.out.println("Primer enunciado: " + claseUno);
		System.out.println("Tipo relacion: " + tipoRelacion);
		System.out.println("Segundo enunciado: " + claseDos);

		if (agenteAjax.registrarRelaciones(claseUno, tipoRelacion, claseDos)) {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos Ok");
		} else {
			ajaxResult.addCampo("estatus", EnumRespuestaAjax.NO_ENCONTRADO);
			ajaxResult.addCampo("data", "registrarDatos FAIL");
		}
		return "obtClases";
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
		return "obtClases";
	}

	/**
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * @return
	 */
	public String edit() {
		version = versionBs.ObtenerUltimaVersion(model.getId());
		return "edit";
	}

	public String editVersion() {
		version = busquedaBs.findById(Version.class, idVersionSel);
		return "edit";
	}

	/**
	 * Actualiza el xml de la clase diagrama para
	 * 
	 * @return
	 */
	public String guardarVersion() {
		System.err.println("data" + data);
		Usuario usuario = (Usuario) SesionController.get("session_user");
		Alumno alumno = alumnoBs.obtenerAlumnoByUser(usuario.getId());
		versionBs.registrarVersion(model.getId(), alumno.getId(), data);
		getAjaxResult();
		ajaxResult.addCampo("actionMessage", "El diagrama se guardo con exito!!");
		return "obtMetodos";
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

	public String getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public String getClaseUno() {
		return claseUno;
	}

	public void setClaseUno(String claseUno) {
		this.claseUno = claseUno;
	}

	public List<String> getListMetodos() {
		return listMetodos;
	}

	public void setListMetodos(List<String> listMetodos) {
		this.listMetodos = listMetodos;
	}

	public List<String> getListAtributos() {
		return listAtributos;
	}

	public void setListAtributos(List<String> listAtributos) {
		this.listAtributos = listAtributos;
	}

	public List<String> getListClases() {
		return listClases;
	}

	public void setListClases(List<String> listClases) {
		this.listClases = listClases;
	}

	public String getClaseDos() {
		return claseDos;
	}

	public void setClaseDos(String claseDos) {
		this.claseDos = claseDos;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Diagrama getModel() {
		return model;
	}

	public void setModel(Diagrama model) {
		this.model = model;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getIdVersionSel() {
		return idVersionSel;
	}

	public void setIdVersionSel(Integer idVersionSel) {
		this.idVersionSel = idVersionSel;
	}	

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getLibre() {
		return libre;
	}

	public void setLibre(Integer libre) {
		this.libre = libre;
	}

}
