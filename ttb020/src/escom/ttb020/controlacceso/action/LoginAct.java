package escom.ttb020.controlacceso.action;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
/*	Acción que permite el Login, es decir ingresar a la aplicación web al ser
 *  un usuario registrado
 * */
@Namespace("/acceso")//Forma parte del espacio de nombres, de esta forma se sabe como ir construyendo la URL para invocar al action
/*Los resultados posibles, es decir, a donde se redireccionará la aplicación web, existen 2 actores diferentes, por lo tanto
 * si el login es exitoso, se trata de un profesor o de un alumno, en cualquier caso redirige al index que se encuentra dentro
 * de las carpetas especificadas en "params" dependiendo el Result
 * */
@Results({
		@Result(name = "profesor", type = "redirectAction", params = { "actionName", "../profesor/gestionar-grupo" }),
		@Result(name = "alumno", type = "redirectAction", params = { "actionName", "../alumno/gestionar-bienvenida" }) })
public class LoginAct extends ActionSupport {
	//Permite imprimir en el Log
	private static final Logger LOG = LogManager.getLogger(LoginAct.class);
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

	/** Este método se invoca cuando se hace una petición GET a este Accion
	 * Redirige al index del paquete al que pertenece este Action
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
	 * Este método se invoca cuando se hace una petición POST a este Accion
	 * Se encarga de validar si el login (usuario) y password son correctos
	 */
	public void validateCreate() {
		try {
			System.err.println("PASSACT"+password);
			//En caso exitoso agrega al SesionController el session_user
			loginBs.ingresar(login, password);
		} catch (UserNotFoundException e) {
			addActionError(getText("Usuario o contrasena no encontrados"));
			System.err.println("Usuario no encontrado");
		} catch (WrongLoginException ee) {
			addActionError(getText("Usuario o contrasena no encontrados"));
			System.err.println("Contrasena no encontrada");
		}

	}

	/** Este método se invoca cuando se hace una petición POST a este Accion
	 * Al recibir nombre de usuario y contraseña correctos crea un objeto de tipo Usuario
	 * posteriormente se invoca al metodo para redireccionar en caso de ser alumno o profesor
	 * @return
	 */
	public String create() {
		Usuario usuario = (Usuario) SesionController.get("session_user");
		return redireccionarPorPerfil(usuario);
	}

	/**Redirecciona a las páginas de inicio de sesión dependiendo del tipo de usuario, 
	 * profesor o alumno
	 * @param usuario
	 * @return
	 */
	public String redireccionarPorPerfil(Usuario usuario) {
		//LOG.info("LOGINACT");
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
