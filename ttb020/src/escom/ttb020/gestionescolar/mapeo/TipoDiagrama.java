package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*Mapeo a la tabla ge10_tipo_diagrama */
@Entity
@Table(name="ge10_tipo_diagrama")
public class TipoDiagrama {
	
	public enum TipoDiagramaEnum {
		CU(1), CLASES(2);
		
		private Integer valor;
		
		private TipoDiagramaEnum(Integer valor) {
			this.valor = valor;
		}
		
		/**
		 * @return the valor
		 */
		public Integer getValor() {
			return valor;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tipo_diagrama")
	private Integer id;
	
	@Column(name="nb_tipo")
	private String nombre;

	public TipoDiagrama() {
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
