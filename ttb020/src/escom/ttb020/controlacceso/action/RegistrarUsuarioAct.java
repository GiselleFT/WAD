package escom.ttb020.controlacceso.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.controlacceso.bs.UsuarioBs;
import escom.ttb020.controlacceso.bs.exception.RepeatedUserException;
import escom.ttb020.controlacceso.bs.exception.WrongLoginException;
import escom.ttb020.controlacceso.mapeo.Perfil;
import escom.ttb020.controlacceso.mapeo.Usuario;

@Namespace("/acceso")
@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "login" }) })
public class RegistrarUsuarioAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8815876762521099425L;

	/**
	 * Objeto generico de busqueda en base de datos
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();

	/**
	 * 
	 */
	private UsuarioBs usuarioBs = new UsuarioBs();

	/**
	 * 
	 */
	private List<Perfil> listPerfiles;

	/**
	 * Objeto de tipo usuario que sobre el cual se aplicaran las operaciones
	 */
	private Usuario model;

	/**
	 * Confirmación de contraseña
	 */
	private String confirmacion;
	
	/**
	 * Nombre del usuario
	 */
	private String nombre;
	
	/**
	 * primer apellido del usuario
	 */
	private String primerApellido;
	
	/**
	 * Segundo apellido del usuario
	 */
	private String segundoApellido;

	/**
	 * @return
	 */
	public String editNew() {
		listPerfiles = busquedaBs.findAll(Perfil.class);
		return "editNew";
	}

	/**
	 * @return
	 */
	public void validateCreate() {
		listPerfiles = busquedaBs.findAll(Perfil.class);
		try{
			usuarioBs.registrarUsuario(model, confirmacion, nombre, primerApellido, segundoApellido);
		}catch(WrongLoginException e) {
			addFieldError("confirmacion",getText("Confirmación Incorrecta"));
			System.err.println("Confirmación no coincide");
		}catch(RepeatedUserException u) {
			addFieldError("model.login",getText("Usuario registrado anteriormente"));
			System.err.println("Usuario repetido");
		}
		
	}

	public String create() {
		addActionMessage("Usuario " + model.getLogin() + " registrado exitosamente");
		System.err.println("Usuario registrado");
		return "success";
	}

	/**
	 * @return
	 */
	public List<Perfil> getListPerfiles() {
		return listPerfiles;
	}

	/**
	 * @param listPerfiles
	 */
	public void setListPerfiles(List<Perfil> listPerfiles) {
		this.listPerfiles = listPerfiles;
	}

	/**
	 * @return
	 */
	public Usuario getModel() {
		return model;
	}

	/**
	 * @param model
	 */
	public void setModel(Usuario model) {
		this.model = model;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	

}
