package escom.ttb020.controlacceso.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.controlacceso.bs.LoginBs;
import escom.ttb020.controlacceso.bs.exception.UserNotFoundException;
import escom.ttb020.controlacceso.bs.exception.WrongLoginException;
import escom.ttb020.controlacceso.mapeo.Perfil.PerfilUsuarioEnum;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.util.SesionController;

@Namespace("/acceso")
@Results({
		@Result(name = "profesor", type = "redirectAction", params = { "actionName", "../profesor/gestionar-grupo" }),
		@Result(name = "alumno", type = "redirectAction", params = { "actionName", "../alumno/gestionar-bienvenida" }) })
public class LoginAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2984533912844332424L;

	/**
	 * 
	 */
	private String login;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private LoginBs loginBs = new LoginBs();

	/**
	 * @return
	 */
	public String index() {
		setActionMessages(getActionMessages());
		ServletContext servletContext = ServletActionContext.getServletContext();
		String context = servletContext.getRealPath("/");
		System.out.println(context);
		return "index";
	}

	/**
	 * 
	 */
	public void validateCreate() {
		try {
			System.err.println("PASSACT"+password);
			loginBs.ingresar(login, password);
		} catch (UserNotFoundException e) {
			addActionError(getText("Usuario o contraseña no encontrados"));
			System.err.println("Usuario no encontrado");
		} catch (WrongLoginException ee) {
			addActionError(getText("Usuario o contraseña no encontrados"));
			System.err.println("Contraseña no encontrada");
		}

	}

	/**
	 * @return
	 */
	public String create() {
		Usuario usuario = (Usuario) SesionController.get("session_user");
		return redireccionarPorPerfil(usuario);
	}

	/**
	 * @param usuario
	 * @return
	 */
	public String redireccionarPorPerfil(Usuario usuario) {
		if (usuario.getPerfil().getId() == PerfilUsuarioEnum.PROFESOR.getValor()) {
			return "profesor";
		} else {
			return "alumno";
		}
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

}
