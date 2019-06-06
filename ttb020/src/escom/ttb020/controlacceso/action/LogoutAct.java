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

@Namespace("/acceso")
//Cuando el logout es exitoso, redirige a la página principal, es decir al Login
@Results({
		@Result(name = "inicio", type = "redirectAction", params = {"actionName", "../acceso/login" })
		})
public class LogoutAct extends ActionSupport {
	private static final Logger LOG = LogManager.getLogger(LogoutAct.class);
	
	private static final long serialVersionUID = -2984533912844332424L;

	/** Este método se invoca cuando se hace una petición GET a este Accion
	 * @return
	 */
	public String index() {
		setActionMessages(getActionMessages());
		ServletContext servletContext = ServletActionContext.getServletContext();
		String context = servletContext.getRealPath("/");
		System.out.println(context);
		SesionController.clear();
		return "index";
	}

	
	/** Este método se invoca cuando se hace una petición POST a este Accion, 
	 * se borran toda la información existente en el SesionController y se invoca al metodo que redireccionará 
	 * la página
	 * @return
	 */
	public String create() {
		SesionController.clear();
		return redireccionarInicio();
	}

	/* Redirecciona al Result de Login*/
	public String redireccionarInicio() {
		return "inicio";
	}


}
