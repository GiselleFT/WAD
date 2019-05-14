package escom.ttb020.gestionescolar.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoGrupoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8591131359259311862L;

	/**
	 * 
	 */
	@Column(name = "id_grupo")
	private Integer idGrupo;

	/**
	 * 
	 */
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	public AlumnoGrupoId() {
		super();
	}

	/**
	 * @param idGrupo
	 * @param idAlumno
	 */
	public AlumnoGrupoId(Integer idGrupo, Integer idAlumno) {
		this.idGrupo = idGrupo;
		this.idAlumno = idAlumno;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlumno == null) ? 0 : idAlumno.hashCode());
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
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
		AlumnoGrupoId other = (AlumnoGrupoId) obj;
		if (idAlumno == null) {
			if (other.idAlumno != null)
				return false;
		} else if (!idAlumno.equals(other.idAlumno))
			return false;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
			return false;
		return true;
	}

}
