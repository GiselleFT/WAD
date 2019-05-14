package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ge04_alumno")
public class Alumno {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_alumno")
	private Integer id;

	/**
	 * 
	 */
	@Column(name = "nb_alumno")
	private String nombre;

	/**
	 * 
	 */
	@Column(name = "primer_apellido")
	private String primerApellido;

	/**
	 * 
	 */
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	
	/**
	 * 
	 */
	@Column(name="id_user")
	private Integer idUser;
	
	/**
	 * Constructor por defecto
	 */
	public Alumno() {
		super();
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
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return nombre + " " + primerApellido + " " + segundoApellido;
	}
	

}
