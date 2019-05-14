package escom.ttb020.controlacceso.bs;

import java.util.List;

import javax.transaction.Transactional;

import escom.ttb020.bs.util.BusquedaBs;
import escom.ttb020.controlacceso.bs.exception.RepeatedUserException;
import escom.ttb020.controlacceso.bs.exception.WrongLoginException;
import escom.ttb020.controlacceso.mapeo.Perfil.PerfilUsuarioEnum;
import escom.ttb020.controlacceso.mapeo.Usuario;
import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.bs.AlumnoBs;
import escom.ttb020.gestionescolar.bs.ProfesorBs;
import escom.ttb020.gestionescolar.mapeo.Alumno;
import escom.ttb020.gestionescolar.mapeo.Profesor;

public class UsuarioBs {

	/**
	 * Metodo generico de busqueda en base de datos
	 */
	private BusquedaBs busquedaBs = new BusquedaBs();
	/**
	 * Metodo generico de acceso a datos
	 */
	private CapaModelo capaModelo = new CapaModelo();

	/**
	 * 
	 */
	private ProfesorBs profesorBs = new ProfesorBs();
	
	/**
	 * 
	 */
	private AlumnoBs alumnoBs= new AlumnoBs();

	/**
	 * @param login
	 * @return
	 */
	public Usuario buscarUsuario(String login) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		List<Usuario> listUsuarios = busquedaBs.findByExample(usuario);
		if (!listUsuarios.isEmpty()) {
			usuario = listUsuarios.get(0);
		} else {
			usuario = null;
		}
		return usuario;
	}

	/**
	 * Registra un usuario en base de datos
	 * 
	 * @param model
	 * @return
	 */
	@Transactional(rollbackOn = Exception.class)
	public Usuario registrarUsuario(Usuario model, String confirmacion, String nombre, String pApellido,
			String sApellido) throws WrongLoginException, RepeatedUserException {
		if (buscarUsuario(model.getLogin()) == null) {
			if (model.getPassword().equals(confirmacion)) {
				capaModelo.save(model);
				if (model.getIdPerfil() == PerfilUsuarioEnum.PROFESOR.getValor()) {
					Profesor profesor = new Profesor();
					profesor.setNombre(nombre);
					profesor.setPrimerApellido(pApellido);
					profesor.setSegundoApellido(sApellido);
					profesorBs.registrarProfesor(profesor, model.getId());
				}else {
					Alumno alumno = new Alumno();
					alumno.setNombre(nombre);
					alumno.setPrimerApellido(pApellido);
					alumno.setSegundoApellido(sApellido);
					alumnoBs.registrarAlumno(alumno, model.getId());
				}
			} else {
				throw new WrongLoginException();
			}
		} else {
			throw new RepeatedUserException();
		}
		return model;
	}
}
