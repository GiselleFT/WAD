package escom.ttb020.bs.IA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

@Scoped(Scope.SINGLETON)
public class AgenteAjax {
	/*
	 * ArrayList con los articulos de un enunciado que seran descartados
	 */
	ArrayList<String> listArticulos = new ArrayList<String>(Arrays.asList("el", "la", "los", "las", "un", "unos", "una",
			"unas", "este", "esta", "estos", "estas", "del", "lo", "al", "de", "a"));
	ManagerXML managerXML = new ManagerXML();

	/**
	 * @return
	 */

	public ArrayList<String> getData(Relation relation, String nomCu) {

		String resultado = preparaEnunciado(nomCu);
		System.out.println("resultado: " + StringUtils.stripAccents(resultado.toLowerCase()));

		ArrayList<String> data;
		data = managerXML.inUseCaseGet(relation, StringUtils.stripAccents(resultado.toLowerCase()));

		return data;
	}

	public Boolean registrarDatos(String ncu, String rel, String ncu2) {
		UseCase useCase = new UseCase();
		ArrayList<RelationUC> array = new ArrayList<RelationUC>();
		
		String caso1 = StringUtils.stripAccents(preparaEnunciado(ncu).toLowerCase());
		String caso2 = StringUtils.stripAccents(preparaEnunciado(ncu2).toLowerCase());

		RelationUC relation = new RelationUC();
		relation.setIntent("0");
		relation.setName(caso2);
		array.add(relation);
		useCase.setEntity(caso1);

		if (rel.equalsIgnoreCase("extends"))
			useCase.setrExtends(array);
		else if (rel.equalsIgnoreCase("include"))
			useCase.setrIncludes(array);

		return managerXML.createOrUpdateUseCase(useCase);
	}

	public String preparaEnunciado(String nomCu) {
		String elementos[] = nomCu.split(" ");
		String verbo = elementos[0];
		String resultado = "";
		
		/*
		 * se divide la cadena para obtener el verbo y la entidad para facilitar la
		 * busqueda en el modelado XML
		 */
		if (elementos.length > 2) {
			for (int i = 1; i < elementos.length; i++) {
				if (!listArticulos.contains(new String(elementos[i]))) {
					resultado = resultado + elementos[i] + " ";
				}
			}
			resultado = verbo + " " + resultado.substring(0,resultado.length()-1);
		} else {
			resultado = nomCu;
		}
		return resultado;
	}

	/**
	 * Obtiene las clases relacionadas dependiendo de la relacion seleccionada
	 * 
	 * @param clase
	 * @param relacion
	 * @return
	 */
	public List<String> obtenerClasesRelacionadas(String clase, String tipoRelacion) {
		List<String> listClases = new ArrayList<String>();
		if(tipoRelacion.equals("dependencia")) {
			listClases = managerXML.getClassElements(StringUtils.stripAccents(clase), ElementCD.DEPENDENCY);
		}else if(tipoRelacion.equals("composicion")) {
			listClases = managerXML.getClassElements(StringUtils.stripAccents(clase), ElementCD.COMPOSITION);
		}else if(tipoRelacion.equals("agregacion")) {
			listClases = managerXML.getClassElements(StringUtils.stripAccents(clase), ElementCD.AGGREGATION);
		}else if(tipoRelacion.equals("asociacion")) {
			listClases = managerXML.getClassElements(StringUtils.stripAccents(clase), ElementCD.ASSOCIATION);
		}else if(tipoRelacion.equals("herencia")) {
			listClases = managerXML.getClassElements(StringUtils.stripAccents(clase), ElementCD.INHERITANCE);
		}
		return listClases;
	}
	
	
	/**
	 * Obtiene los metodos de una clase seleccionada
	 * 
	 * @param clase
	 * @return
	 */
	public List<String> obtenerMetodos(String clase){
		return managerXML.getClassElements(clase, ElementCD.METHOD);
	}
	
	/**
	 * Obtiene los atributos de una clase
	 * 
	 * @param clase
	 * @return
	 */
	public List<String> obtenerAtributos(String clase){
		return managerXML.getClassElements(clase, ElementCD.ATTRIBUTE);
	}
	
	/**
	 * Registra una relación desconocida para el sistema, reconociendo el comportamiento del usuario
	 * 
	 * @param claseUno
	 * @param relacion
	 * @param claseDos
	 * @return
	 */
	public Boolean registrarRelaciones(String claseUno, String tipoRelacion, String claseDos) {
		Boolean result = false;
		if(tipoRelacion.equals("dependencia")) {
			result = managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(claseDos), ElementCD.DEPENDENCY);
		}else if(tipoRelacion.equals("composicion")) {
			result = managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(claseDos), ElementCD.COMPOSITION);
		}else if(tipoRelacion.equals("agregacion")) {
			result = managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(claseDos), ElementCD.AGGREGATION);
		}else if(tipoRelacion.equals("asociacion")) {
			result = managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(claseDos), ElementCD.ASSOCIATION);
		}else if(tipoRelacion.equals("herencia")) {
			result = managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(claseDos), ElementCD.INHERITANCE);
		}
		return result;
		
	}
	
	public Boolean registrarAtributos(String claseUno, String atributo) {
		return managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(atributo), ElementCD.ATTRIBUTE);	
	}
	
	public Boolean registrarMetodos(String claseUno, String metodo) {
		return managerXML.createOrUpdateClassDiagram(StringUtils.stripAccents(claseUno), StringUtils.stripAccents(metodo), ElementCD.METHOD);	
	}
}
