package escom.ttb020.util;

import com.opensymphony.xwork2.ActionContext;

public class SesionController {

	public static Object get(String nombre) {
		return ActionContext.getContext().getSession().get(nombre);
	}

	public static Object put(String nombre, Object o) {
		return ActionContext.getContext().getSession().put(nombre, o);
	}
	
	public static Object delete(String nombre) {
		return ActionContext.getContext().getSession().remove(nombre);
	}
}
