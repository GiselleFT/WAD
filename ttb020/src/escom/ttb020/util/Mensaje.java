package escom.ttb020.util;

import java.io.Serializable;
import java.util.List;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = -7353722997022221667L;

	public enum EnumTipoMensaje {
		FIELD_ERROR(1), ACTION_MESSAGE(2), ACTION_ERROR(3);

		private Integer id;

		private EnumTipoMensaje(Integer id) {
			this.id = id;
		}

		public Integer getId() {
			return id;
		}
	}

	private EnumTipoMensaje enumTipoMensaje;

	private String nombre;

	private List<String> mensajes;

	public Mensaje() {
		super();
	}

	public Mensaje(EnumTipoMensaje enumTipoMensaje, String nombre, List<String> mensajes) {
		super();
		this.enumTipoMensaje = enumTipoMensaje;
		this.nombre = nombre;
		this.mensajes = mensajes;
	}

	public EnumTipoMensaje getEnumTipoMensaje() {
		return enumTipoMensaje;
	}

	public Mensaje(EnumTipoMensaje enumTipoMensaje, List<String> mensajes) {
		super();
		this.enumTipoMensaje = enumTipoMensaje;
		this.mensajes = mensajes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}

}
