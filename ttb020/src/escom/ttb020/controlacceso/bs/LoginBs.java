package escom.ttb020.controlacceso.bs;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.controlacceso.bs.exception.UserNotFoundException;
import escom.ttb020.controlacceso.bs.exception.WrongLoginException;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.util.SesionController;

@Scoped(Scope.SINGLETON)
public class LoginBs {
	
	private UsuarioBs usuarioBS = new UsuarioBs();
	/*Valida que el usuario y la contraseña son correctos*/
	public Usuario ingresar(String login, String password) throws UserNotFoundException, WrongLoginException {
		Usuario user = usuarioBS.buscarUsuario(login);
		if(user == null) {
			System.err.println("Usuario no encontrado");
			throw new UserNotFoundException();
		}else {
			System.err.println(password);
			System.err.println(user.getPassword());
			if(password.equals(user.getPassword())) {
				/*Si el login fue exitoso crea la sesión para el usuario logeado*/
				SesionController.put("session_user", user);
			}else {
				throw new WrongLoginException();
			}
		}
		return user;
	}
}
