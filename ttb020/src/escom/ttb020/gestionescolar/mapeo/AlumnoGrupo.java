package escom.ttb020.gestionescolar.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ge06_alumno_grupo")
public class AlumnoGrupo {
	
	/**
	 * 
	 */
	@EmbeddedId
	private AlumnoGrupoId id;
	
	/**
	 * 
	 */
	@Column(name="id_grupo", insertable = false, updatable = false)
	private Integer idGrupo;
	
	/**
	 * 
	 */
	@Column(name="id_alumno", insertable = false, updatable = false)
	private Integer idAlumno;
	

	/**
	 * 
	 */
	public AlumnoGrupo() {
		super();
	}

	/**
	 * @param idGrupo
	 * @param idAlumno
	 */
	public AlumnoGrupo(Integer idGrupo, Integer idAlumno) {
		super();
		this.id = new AlumnoGrupoId(idGrupo, idAlumno);
		this.idGrupo = idGrupo;
		this.idAlumno = idAlumno;
	}

	public AlumnoGrupoId getId() {
		return id;
	}

	public void setId(AlumnoGrupoId id) {
		this.id = id;
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

}
