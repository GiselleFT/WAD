package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ge08_alumno_proyecto")
public class AlumnoProyecto {

	@EmbeddedId
	private AlumnoProyectoId id; 

	/**
	 * 
	 */
	@Column(name = "id_alumno", insertable = false, updatable = false)
	private Integer idAlumno;

	/**
	 * 
	 */
	@Column(name = "id_proyecto", insertable = false, updatable = false)
	private Integer idProyecto;
	
	/**
	 * 
	 */
	public AlumnoProyecto() {
		super();
	}
	
	/**
	 * @param idAlumno
	 * @param idProyecto
	 */
	public AlumnoProyecto(Integer idAlumno, Integer idProyecto) {
		this.id = new AlumnoProyectoId(idAlumno, idProyecto);
		this.idAlumno = idAlumno;
		this.idProyecto = idProyecto;
	}

	public AlumnoProyectoId getId() {
		return id;
	}

	public void setId(AlumnoProyectoId id) {
		this.id = id;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

}
