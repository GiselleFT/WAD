package escom.ttb020.gestionescolar.bs;

import javax.transaction.Transactional;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.dao.util.CapaModelo;
import escom.ttb020.gestionescolar.mapeo.Comentario;

@Scoped(Scope.SINGLETON)
public class ComentarioBs {
		
	private CapaModelo capaModelo = new CapaModelo();
	
	/**
	 * Registra un comentario en base de datos
	 * 
	 * @param model
	 * @return
	 */
	@Transactional(rollbackOn = Exception.class)
	public void registrarComentario(String texto, Integer idDiagrama) {
		Comentario comentario = new Comentario();
		comentario.setComentario(texto);
		comentario.setIdDiagrama(idDiagrama);
		capaModelo.save(comentario);
	}
}
