package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*Mapeo a la tabla ge09_diagrama */
@Entity
@Table(name = "ge09_diagrama")
public class Diagrama {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_diagrama")
	private Integer id;

	@Column(name = "nb_diagrama")
	private String nombre;

	@Column(name = "id_proyecto")
	private Integer idProyecto;

	@Column(name = "id_tipo_diagrama")
	private Integer idTipo;

	@Column(name = "estado")
	private Integer estado;

	@Column(name="data")
	private String data;
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable = false, updatable = false)
	private Proyecto proyecto;
	
	/**
	 * 
	 */
	public Diagrama() {
		super();
	}
	
	

	public Diagrama(String nombre, Integer idProyecto, Integer idTipo, Integer estado) {
		super();
		this.nombre = nombre;
		this.idProyecto = idProyecto;
		this.idTipo = idTipo;
		this.estado = estado;
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

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
