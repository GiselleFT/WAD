package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*Mapeo a la tabla ge05_grupo */
@Entity
@Table(name="ge05_grupo")
public class Grupo {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_grupo")
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="nb_grupo")
	private String nombre;
	
	/**
	 * 
	 */
	@Column(name="id_profesor")
	private Integer idProfesor;
	
	/**
	 * 
	 */
	public Grupo() {
		super();
	}

	/**
	 * @param idProfesor
	 */
	public Grupo(Integer idProfesor) {
		super();
		this.idProfesor = idProfesor;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return
	 */
	public Integer getIdProfesor() {
		return idProfesor;
	}

	/**
	 * @param idProfesor
	 */
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

}
