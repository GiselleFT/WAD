package escom.ttb020.bs.util;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import escom.ttb020.dao.util.CapaModelo;

@Scoped(Scope.SINGLETON)
public class BusquedaBs {
	
	private CapaModelo genericDao = new CapaModelo();

	public <C> C findById(Class<C> clazz, Serializable id) {
		return genericDao.findById(clazz, id);
	}

	public <C> List<C> findByExample(C example) {
		return genericDao.findByExample(example);
	}
	
	public <C> List<C> findAll(Class<C> clazz) {
		return genericDao.findAll(clazz);
	}

}
