package escom.ttb020.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*Clase Java, mapea la tabla "cat01_users" de la base de datos*/
@Entity
@Table(name = "cat01_users")
public class Usuario {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_user")
	private Integer id;
	
	/**
	 * 
	 */
	@Column(name = "tx_login")
	private String login;
	
	/**
	 * 
	 */
	@Column(name = "tx_password")
	private String password;
	
	/**
	 * 
	 */
	@Column(name = "id_perfil")
	private Integer idPerfil;
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
	private Perfil perfil;
	
	
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * Constructor por defecto
	 */
	public Usuario() {
		
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
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

}
