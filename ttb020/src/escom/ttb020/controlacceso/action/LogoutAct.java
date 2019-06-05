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
@Results({
		@Result(name = "inicio", type = "redirectAction", params = {"actionName", "../acceso/login" })
		})
public class LogoutAct extends ActionSupport {
	private static final Logger LOG = LogManager.getLogger(LogoutAct.class);
	
	private static final long serialVersionUID = -2984533912844332424L;

	/**
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

	
	/**
	 * @return
	 */
	public String create() {
		SesionController.clear();
		return redireccionarInicio();
	}

	
	public String redireccionarInicio() {
		return "inicio";
	}


}
