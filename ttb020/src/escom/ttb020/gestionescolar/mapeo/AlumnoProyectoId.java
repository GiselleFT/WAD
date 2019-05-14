package escom.ttb020.gestionescolar.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoProyectoId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8397881352001995781L;
	
	/**
	 * 
	 */
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	/**
	 * 
	 */
	@Column(name="id_proyecto")
	private Integer idProyecto;
	
	/**
	 * 
	 */
	public AlumnoProyectoId() {
		super();
	}
	
	public AlumnoProyectoId(Integer idAlumno, Integer idProyecto) {
		super();
		this.idAlumno = idAlumno;
		this.idProyecto = idProyecto;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlumno == null) ? 0 : idAlumno.hashCode());
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoProyectoId other = (AlumnoProyectoId) obj;
		if (idAlumno == null) {
			if (other.idAlumno != null)
				return false;
		} else if (!idAlumno.equals(other.idAlumno))
			return false;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		return true;
	}

}
