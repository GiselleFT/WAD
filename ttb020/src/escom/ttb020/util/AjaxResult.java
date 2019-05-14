package escom.ttb020.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1160549418479781251L;

	public enum EnumRespuestaAjax {
		ENCONTRADO(1), NO_ENCONTRADO(2);

		private Integer tipoRespuesta;

		private EnumRespuestaAjax(Integer tipoRespuesta) {
			this.tipoRespuesta = tipoRespuesta;
		}

		public Integer getTipoRespuesta() {
			return tipoRespuesta;
		}

	}

	private Map<String, Object> response;

	private List<Mensaje> listMessages;

	public AjaxResult() {
		this.response = new HashMap<String, Object>();
		this.listMessages = new ArrayList<Mensaje>();
	}

	public AjaxResult(Map<String, Object> response, List<Mensaje> listMessages) {
		super();
		this.response = response;
		this.listMessages = listMessages;
	}

	public void addCampo(String nombreCampo, Object objeto) {
		response.put(nombreCampo, objeto);
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public List<Mensaje> getListMessages() {
		return listMessages;
	}

	public void setListMessages(List<Mensaje> listMessages) {
		this.listMessages = listMessages;
	}

}
