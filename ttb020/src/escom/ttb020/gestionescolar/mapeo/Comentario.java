package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*Mapeo a la tabla ge11_comentario */
@Entity
@Table(name="ge11_comentario")
public class Comentario {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_comentario")
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="comentario")
	private String comentario;
	
	/**
	 * 
	 */
	@Column(name="id_diagrama")
	private Integer idDiagrama;
	
	/**
	 * 
	 */
	public Comentario() {
		super();
	}
	

	/**
	 * @param id
	 * @param comentario
	 * @param idDiagrama
	 */
	public Comentario(Integer id, String comentario, Integer idDiagrama) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.idDiagrama = idDiagrama;
	}
	
	public Comentario(Integer idDiagrama) {
		super();
		this.idDiagrama = idDiagrama;
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
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Integer getIdDiagrama() {
		return idDiagrama;
	}


	public void setIdDiagrama(Integer idDiagrama) {
		this.idDiagrama = idDiagrama;
	}
}
