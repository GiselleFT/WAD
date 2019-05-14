package escom.ttb020.gestionescolar.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author edson
 *
 */
@Entity
@Table(name="ge12_version")
public class Version {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_version")
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	/**
	 * 
	 */
	@Column(name="id_diagrama")
	private Integer idDiagrama;
	
	/**
	 * 
	 */
	@Column(name="nb_version")
	private Date nombre;
	
	/**
	 * 
	 */
	@Column(name="data")
	private String data;
	
	/**
	 * 
	 */
	@Column(name="st_version")
	private Boolean estatus;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno", insertable = false, updatable = false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "id_diagrama", referencedColumnName = "id_diagrama", insertable = false, updatable = false)
	private Diagrama diagrama;
	
	/**
	 * 
	 */
	public Version() {
		super();
	}

	/**
	 * @param id
	 * @param idAlumno
	 * @param idDiagrama
	 * @param nombre
	 * @param data
	 * @param estatus
	 */
	public Version(Integer id, Integer idAlumno, Integer idDiagrama, Date nombre, String data, Boolean estatus) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.idDiagrama = idDiagrama;
		this.nombre = nombre;
		this.data = data;
		this.estatus = estatus;
	}
	
	public Version(Integer idDiagrama) {
		super();
		this.idDiagrama = idDiagrama;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Integer getIdDiagrama() {
		return idDiagrama;
	}

	public void setIdDiagrama(Integer idDiagrama) {
		this.idDiagrama = idDiagrama;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Date getNombre() {
		return nombre;
	}

	public void setNombre(Date nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Diagrama getDiagrama() {
		return diagrama;
	}

	public void setDiagrama(Diagrama diagrama) {
		this.diagrama = diagrama;
	}

}
