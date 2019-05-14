package escom.ttb020.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cat02_perfil")
public class Perfil {
	
	public enum PerfilUsuarioEnum {
		PROFESOR(1), ALUMNO(2);
		
		private Integer valor;
		
		private PerfilUsuarioEnum(Integer valor) {
			this.valor = valor;
		}
		
		/**
		 * @return the valor
		 */
		public Integer getValor() {
			return valor;
		}
	}
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name="id_perfil")
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="nb_perfil")
	private String nombre;
	
	/**
	 * Constructor por defecto
	 */
	public Perfil() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
