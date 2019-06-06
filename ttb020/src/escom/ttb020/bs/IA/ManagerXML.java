package escom.ttb020.bs.IA;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ManagerXML {
	//Obtencion de un arreglo de todos los diagramas de clase
	public ArrayList<ClassDiagram> getAllClassDiagram() {
		ArrayList<ClassDiagram> clases = new ArrayList<ClassDiagram>();
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/ClassDiagram.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();

			System.out.println("Este el root: " + doc.getDocumentElement().getNodeName());
					
			NodeList nListClass = doc.getElementsByTagName("class");
					
			System.out.println("******************************\n");

			for (int temp = 0; temp < nListClass.getLength(); temp++) {

				Node nNodeClass = nListClass.item(temp);
				ClassDiagram class1 = new ClassDiagram();
				
				if (nNodeClass.getNodeType() == Node.ELEMENT_NODE) {

					Element eElementClass = (Element) nNodeClass;
					
					class1.setName(eElementClass.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Nombre : " + eElementClass.getElementsByTagName("name").item(0).getTextContent());
					class1.setIntent(eElementClass.getElementsByTagName("name").item(0).getAttributes().getNamedItem("intent").getTextContent());
					System.out.println("Intento : " + eElementClass.getElementsByTagName("name").item(0).getAttributes().getNamedItem("intent").getTextContent());
					
					ArrayList<CDElement> attributes = new ArrayList<CDElement>();
					for (int index = 0; index < eElementClass.getElementsByTagName("attribute").getLength(); index++) {
						CDElement attribute = new CDElement();
						attribute.setName(eElementClass.getElementsByTagName("attribute").item(index).getTextContent());
						attribute.setIntent(eElementClass.getElementsByTagName("attribute").item(index).getAttributes().getNamedItem("intent").getTextContent());
						attribute.setType(ElementCD.ATTRIBUTE);
						System.out.println("Atributo " + index + ": "  + attribute.getName());
						System.out.println("Intento " + index + ": "  + attribute.getIntent());
						attributes.add(attribute);
					}
					class1.setAttributes(attributes);
					
					ArrayList<CDElement> methods = new ArrayList<CDElement>();
					for (int index = 0; index < eElementClass.getElementsByTagName("method").getLength(); index++) {
						CDElement method = new CDElement();
						method.setName(eElementClass.getElementsByTagName("method").item(index).getTextContent());
						method.setIntent(eElementClass.getElementsByTagName("method").item(index).getAttributes().getNamedItem("intent").getTextContent());
						method.setType(ElementCD.METHOD);
						System.out.println("Metodo " + index + ": " + method.getName());
						System.out.println("Intento " + index + ": "  + method.getIntent());
						methods.add(method);
					}
					class1.setMethods(methods);
					
					NodeList nListRelations = eElementClass.getElementsByTagName("relations");
					if (nListRelations.getLength() > 0 ) {
						Node nNodeRelation = nListRelations.item(0);
						System.out.println("Relaciones: ");
						
						if (nNodeRelation.getNodeType() == Node.ELEMENT_NODE) {
							Element eElementRelation = (Element) nNodeRelation;
							
							ArrayList<CDElement> inheritances = new ArrayList<CDElement>();
							for (int index = 0; index < eElementRelation.getElementsByTagName("inheritance").getLength(); index++) {
								CDElement inheritance = new CDElement();
								inheritance.setName(eElementRelation.getElementsByTagName("inheritance").item(index).getTextContent());
								inheritance.setIntent(eElementClass.getElementsByTagName("inheritance").item(index).getAttributes().getNamedItem("intent").getTextContent());
								inheritance.setType(ElementCD.INHERITANCE);
								System.out.println("Herencia " + index + ": " + inheritance.getName());
								System.out.println("Intento " + index + ": "  + inheritance.getIntent());
								inheritances.add(inheritance);
							}
							class1.setInheritance(inheritances);
							
							ArrayList<CDElement> rAgregattions = new ArrayList<CDElement>();
							for (int index = 0; index < eElementRelation.getElementsByTagName("aggregation").getLength(); index++) {
								CDElement rAgregattion = new CDElement();
								rAgregattion.setName(eElementRelation.getElementsByTagName("aggregation").item(index).getTextContent());
								rAgregattion.setIntent(eElementClass.getElementsByTagName("aggregation").item(index).getAttributes().getNamedItem("intent").getTextContent());
								rAgregattion.setType(ElementCD.AGGREGATION);
								System.out.println("Agregacion " + index + ": " + rAgregattion.getName());
								System.out.println("Intento " + index + ": "  + rAgregattion.getIntent());
								rAgregattions.add(rAgregattion);
							}
							class1.setAggregation(rAgregattions);
							
							ArrayList<CDElement> rCompositions = new ArrayList<CDElement>();
							for (int index = 0; index < eElementRelation.getElementsByTagName("composition").getLength(); index++) {
								CDElement rComposition = new CDElement();
								rComposition.setName(eElementRelation.getElementsByTagName("composition").item(index).getTextContent());
								rComposition.setIntent(eElementClass.getElementsByTagName("composition").item(index).getAttributes().getNamedItem("intent").getTextContent());
								rComposition.setType(ElementCD.COMPOSITION);
								System.out.println("Composicion " + index + ": " + rComposition.getName());
								System.out.println("Intento " + index + ": "  + rComposition.getIntent());
								rCompositions.add(rComposition);
							}
							class1.setComposition(rCompositions);
							
							ArrayList<CDElement> rAssociations = new ArrayList<CDElement>();
							for (int index = 0; index < eElementRelation.getElementsByTagName("association").getLength(); index++) {
								CDElement rAssociation = new CDElement();
								rAssociation.setName(eElementRelation.getElementsByTagName("association").item(index).getTextContent());
								rAssociation.setIntent(eElementClass.getElementsByTagName("association").item(index).getAttributes().getNamedItem("intent").getTextContent());
								rAssociation.setType(ElementCD.ASSOCIATION);
								System.out.println("Asociasion " + index + ": " + rAssociation.getName());
								System.out.println("Intento " + index + ": "  + rAssociation.getIntent());
								rAssociations.add(rAssociation);
							}
							class1.setAssociation(rAssociations);
							
							ArrayList<CDElement> rDependencys = new ArrayList<CDElement>();
							for (int index = 0; index < eElementRelation.getElementsByTagName("dependency").getLength(); index++) {
								CDElement rDependency = new CDElement();
								rDependency.setName(eElementRelation.getElementsByTagName("dependency").item(index).getTextContent());
								rDependency.setIntent(eElementClass.getElementsByTagName("dependency").item(index).getAttributes().getNamedItem("intent").getTextContent());
								rDependency.setType(ElementCD.DEPENDENCY);
								System.out.println("Dependencia " + index + ": " + rDependency.getName());
								System.out.println("Intento " + index + ": "  + rDependency.getIntent());
								rDependencys.add(rDependency);
							}
							class1.setDependency(rDependencys);
						}
					}
				}
				System.out.println("------------------------------\n");
				clases.add(class1);
			}
			
		    } catch (Exception e) {
		    	e.printStackTrace();
	    }
		return clases;
	}
	
	//Obtencion de un arreglo de todos los diagramas de casos de uso
	public ArrayList<UseCase> getAllUseCase() {
		ArrayList<UseCase> cases = new ArrayList<UseCase>();
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/UseCase.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Este el root: " + doc.getDocumentElement().getNodeName());
			NodeList nListCase = doc.getElementsByTagName("case");		
			System.out.println("******************************\n");

			for (int temp = 0; temp < nListCase.getLength(); temp++) {

				Node nNodeCase = nListCase.item(temp);
				UseCase case1 = new UseCase();
				
				if (nNodeCase.getNodeType() == Node.ELEMENT_NODE) {

					Element eElementCase = (Element) nNodeCase;
					
					case1.setEntity(eElementCase.getElementsByTagName("entity").item(0).getTextContent());
					System.out.println("Nombre : " + eElementCase.getElementsByTagName("entity").item(0).getTextContent());
					
					case1.setIntent(eElementCase.getElementsByTagName("entity").item(0).getAttributes().getNamedItem("intent").getTextContent());
					System.out.println("Intento: " + eElementCase.getElementsByTagName("entity").item(0).getAttributes().getNamedItem("intent").getTextContent());
					
					ArrayList<RelationUC> rExtends = new ArrayList<RelationUC>();
					for (int index = 0; index < eElementCase.getElementsByTagName("extend").getLength(); index++) {
						RelationUC rExtend = new RelationUC();
						rExtend.setName(eElementCase.getElementsByTagName("extend").item(index).getTextContent());
						rExtend.setIntent(eElementCase.getElementsByTagName("extend").item(index).getAttributes().getNamedItem("intent").getTextContent());
						rExtends.add(rExtend);
						System.out.println("          Extend: "  + eElementCase.getElementsByTagName("extend").item(index).getTextContent());
						System.out.println("          	Intent: "  + eElementCase.getElementsByTagName("extend").item(index).getAttributes().getNamedItem("intent").getTextContent());
					}
					case1.setrExtends(rExtends);
					
					ArrayList<RelationUC> rIncludes = new ArrayList<RelationUC>();
					for (int index = 0; index < eElementCase.getElementsByTagName("include").getLength(); index++) {
						RelationUC rInclude = new RelationUC();
						rInclude.setName(eElementCase.getElementsByTagName("include").item(index).getTextContent());
						rInclude.setIntent(eElementCase.getElementsByTagName("include").item(index).getAttributes().getNamedItem("intent").getTextContent());
						rIncludes.add(rInclude);
						System.out.println("          Include: "  + eElementCase.getElementsByTagName("include").item(index).getTextContent());
						System.out.println("          	Intent: "  + eElementCase.getElementsByTagName("include").item(index).getAttributes().getNamedItem("intent").getTextContent());
					}
					case1.setrIncludes(rIncludes);
					
				}
				cases.add(case1);
				System.out.println("------------------------------\n");
			}
		    } catch (Exception e) {
		    	e.printStackTrace();
	    }
		return cases;
	}
	
	//Obtencion de un arreglo de todos los actores
	public ArrayList<Actor> getAllActors(String pathXml) {
		// TODO Auto-generated method stub
		ArrayList<Actor> actores = new ArrayList<Actor>();
		try {
			File fXmlFile = new File(pathXml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();

			System.out.println("Este el root: " + doc.getDocumentElement().getNodeName());
					
			NodeList nListActor = doc.getElementsByTagName("actor");
					
			System.out.println("******************************\n");

			for (int temp = 0; temp < nListActor.getLength(); temp++) {

				Node nNodeActor = nListActor.item(temp);
				Actor actorNuevo = new Actor();
				
				if (nNodeActor.getNodeType() == Node.ELEMENT_NODE) {

					Element eElementActor = (Element) nNodeActor;
					
					actorNuevo.setName(eElementActor.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Nombre : " + eElementActor.getElementsByTagName("name").item(0).getTextContent());
					
					ArrayList<String> hereda = new ArrayList<String>();
					for (int index = 0; index < eElementActor.getElementsByTagName("hereda").getLength(); index++) {
						hereda.add(eElementActor.getElementsByTagName("hereda").item(index).getTextContent());
						System.out.println("          Hereda: "  + eElementActor.getElementsByTagName("hereda").item(index).getTextContent());
					}
					actorNuevo.setHereda(hereda);
					
				}
				actores.add(actorNuevo);
				System.out.println("------------------------------\n");
			}
		    } catch (Exception e) {
		    	e.printStackTrace();
	    }
		return actores;
	}
	
	public ArrayList<String> inUseCaseGet(Relation relation, String whitEntity){
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<UseCase> diagrams = this.getAllUseCase();
		for (UseCase diagram : diagrams) {
			if (diagram.getEntity().equals(whitEntity)) {
				int intent = Integer.parseInt(diagram.getIntent());
				if (intent > 5) {
					switch (relation) {
						case EXTEND:
							results = this.getRelationsToRecommend(diagram.getrExtends());
							break;
						case INCLUDE:
							results = this.getRelationsToRecommend(diagram.getrIncludes());
							break;
						default:
							break;
					}
				}
				break;
			}
		}
		return results;
	}
	
	public ArrayList<String> getRelationsToRecommend(ArrayList<RelationUC> relations){
		ArrayList<RelationUC> results = new ArrayList<RelationUC>();
		for (RelationUC relation : relations) {
			int intento = Integer.parseInt(relation.getIntent());
			if (intento > 5)
				results.add(relation);
		}
		
		return this.getRelationsName(results);
	}
	
	public ArrayList<String> getRelationsName(ArrayList<RelationUC> relations) {
		ArrayList<String> results = new ArrayList<String>();
		Collections.sort(relations, RelationUC.comparador);
		
		for(RelationUC relationUC : relations) {
			results.add(relationUC.getName()); 
		}
		
		return results;
	}
	
	
	public Boolean createUseCase(UseCase useCase) {
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/UseCase.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Element root = doc.getDocumentElement();
			
			Element newUseCase = doc.createElement("case");
			Element entity = doc.createElement("entity");
			entity.setAttribute("intent", "1");
			entity.appendChild(doc.createTextNode(useCase.getEntity()));
			newUseCase.appendChild(entity);

	        if (useCase.getrExtends() != null && useCase.getrExtends().size() > 0) {
		        Element extend = doc.createElement("extend");
		        extend.appendChild(doc.createTextNode(useCase.getrExtends().get(0).getName()));
		        extend.setAttribute("intent", "1");
		        newUseCase.appendChild(extend);
	        }

	        if (useCase.getrIncludes() != null && useCase.getrIncludes().size() > 0) {
		        Element include = doc.createElement("include");
		        include.appendChild(doc.createTextNode(useCase.getrIncludes().get(0).getName()));
		        include.setAttribute("intent", "1");
		        newUseCase.appendChild(include);
	        }
	        
	        root.appendChild(newUseCase);
	        
	        DOMSource source = new DOMSource(doc);

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "UseCase.dtd");
	        StreamResult result = new StreamResult(fXmlFile);
	        transformer.transform(source, result);
		} catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
		}
		return true;
	}
	
	public Boolean updateUseCase(UseCase useCase) {
		Boolean updated = false;
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/UseCase.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nListCase = doc.getElementsByTagName("case");
			
			for (int temp = 0; temp < nListCase.getLength(); temp++) {
				Node nNodeCase = nListCase.item(temp);
				
				if (nNodeCase.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementCase = (Element) nNodeCase;
					
					if (useCase.getEntity().equals(eElementCase.getElementsByTagName("entity").item(0).getTextContent())) {
						Node nEntity = eElementCase.getElementsByTagName("entity").item(0).getAttributes().getNamedItem("intent");
						int intent = Integer.parseInt(nEntity.getNodeValue());
						intent += 1;
						nEntity.setNodeValue(String.valueOf(intent));
						
						if (useCase.getrExtends() != null && useCase.getrExtends().size() > 0) {
						Boolean exist = false;
							for (int index = 0; index < eElementCase.getElementsByTagName("extend").getLength(); index++) {
								if (useCase.getrExtends().get(0).getName().equals(eElementCase.getElementsByTagName("extend").item(index).getTextContent())) {
									Node nToUpdate = eElementCase.getElementsByTagName("extend").item(index).getAttributes().getNamedItem("intent");
									int val = Integer.parseInt(nToUpdate.getNodeValue());
									val += 1;
									nToUpdate.setNodeValue(String.valueOf(val));
									exist = true;
									break;
								}
							}
							if (!exist) {
						        Element extend = doc.createElement("extend");
						        extend.setAttribute("intent", "1");
						        extend.appendChild(doc.createTextNode(useCase.getrExtends().get(0).getName()));
						        eElementCase.appendChild(extend);
							}
				        }

						if (useCase.getrIncludes() != null && useCase.getrIncludes().size() > 0) {
						Boolean exist = false;
							for (int index = 0; index < eElementCase.getElementsByTagName("include").getLength(); index++) {
								if (useCase.getrIncludes().get(0).getName().equals(eElementCase.getElementsByTagName("include").item(index).getTextContent())) {
									Node nToUpdate = eElementCase.getElementsByTagName("include").item(index).getAttributes().getNamedItem("intent");
									int val = Integer.parseInt(nToUpdate.getNodeValue());
									val += 1;
									nToUpdate.setNodeValue(String.valueOf(val));
									exist = true;
									break;
								}
							}
							if (!exist) {
						        Element include = doc.createElement("include");
						        include.setAttribute("intent", "1");
						        include.appendChild(doc.createTextNode(useCase.getrIncludes().get(0).getName()));
						        eElementCase.appendChild(include);
							}
				        }
						
				        updated = true;
				        break;
					}
				}
			}
			
			if (updated) {
				TransformerFactory transformerFactory = TransformerFactory
	                    .newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
		        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "UseCase.dtd");
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fXmlFile);
	            transformer.transform(source, result);
			}
            
		} catch (Exception e) {
	    	e.printStackTrace();
		}
		return updated;
	}
	
	public Boolean createOrUpdateUseCase(UseCase useCase) {
		Boolean response = true;
		response = this.updateUseCase(useCase);
		if (!response) {
			response = this.createUseCase(useCase);
		}
		return response;
	}
	
	public String validateType(ElementCD type) {
		switch (type) {
			case AGGREGATION:
				return "aggregation";
			case ASSOCIATION:
				return "association";
			case ATTRIBUTE:
				return "attribute";
			case COMPOSITION:
				return "composition";
			case DEPENDENCY:
				return "dependency";
			case INHERITANCE:
				return "inheritance";
			case METHOD:
				return "method";
			default:
				return "";
		
		}
	}
	
	public ArrayList<String> getClassElements(String className, ElementCD type){
		ArrayList<ClassDiagram> diagrams = this.getAllClassDiagram();
		for (ClassDiagram diagram : diagrams) {
			if(diagram.getName().equalsIgnoreCase(className)) {
				ArrayList<String> results = new ArrayList<String>();
				ArrayList<CDElement> resultsCDElements = new ArrayList<CDElement>();
				ArrayList<CDElement> elementos = new ArrayList<CDElement>();
				switch (type) {
					case AGGREGATION:
						elementos = diagram.getAggregation();
						break;
					case ASSOCIATION:
						elementos = diagram.getAssociation();
						break;
					case ATTRIBUTE:
						elementos = diagram.getAttributes();
						break;
					case COMPOSITION:
						elementos = diagram.getComposition();
						break;
					case DEPENDENCY:
						elementos = diagram.getDependency();
						break;
					case INHERITANCE:
						elementos = diagram.getInheritance();
						break;
					case METHOD:
						elementos = diagram.getMethods();
						break;
					default:
						return null;

				}
				if (!elementos.isEmpty()) {
					for (CDElement element : elementos) { 
						int intento = Integer.parseInt(element.getIntent());
						if (intento > 5)
							resultsCDElements.add(element);
					}
					
					Collections.sort(resultsCDElements, ClassDiagram.comparador);
					
					for (CDElement element : resultsCDElements)
						results.add(element.getName());
					return results;
				}
			}
		}
		return null;
	}
	
	public Boolean createClassDiagram(String className, String element, ElementCD type) {
		String sType = this.validateType(type);
		
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/ClassDiagram.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Element root = doc.getDocumentElement();

			Element newClassDiagram = doc.createElement("class");
			Element entity = doc.createElement("name");
			entity.setAttribute("intent", "1");
			entity.appendChild(doc.createTextNode(className));
			newClassDiagram.appendChild(entity);
			
			if (type != ElementCD.ATTRIBUTE && type != ElementCD.METHOD) {
				Element relation = doc.createElement("relations");
				Element newElement = doc.createElement(sType);
				newElement.appendChild(doc.createTextNode(element));
				newElement.setAttribute("intent", "1");
				relation.appendChild(newElement);
				newClassDiagram.appendChild(relation);
				root.appendChild(newClassDiagram);
			} else {
				Element newElement = doc.createElement(sType);
				newElement.appendChild(doc.createTextNode(element));
				newElement.setAttribute("intent", "1");
				newClassDiagram.appendChild(newElement);
				root.appendChild(newClassDiagram);
			}

			DOMSource source = new DOMSource(doc);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ClassDiagram.dtd");
			StreamResult result = new StreamResult(fXmlFile);
	        transformer.transform(source, result);
		} catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
		}
		return true;
	}
	
	public Boolean updateClassDiagram(String className, String element, ElementCD type) {
		Boolean updated = false;
		String sType = this.validateType(type);
		
		try {
			File fXmlFile = new File("src/main/webapp/resources/xmls/ClassDiagram.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nListClass = doc.getElementsByTagName("class");
			
			for (int temp = 0; temp < nListClass.getLength(); temp++) {
				Node nNodeClass = nListClass.item(temp);
				
				if (nNodeClass.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementClass = (Element) nNodeClass;
					
					if (className.equals(eElementClass.getElementsByTagName("name").item(0).getTextContent())) {
						Boolean exist = false;
						Node nEntity = eElementClass.getElementsByTagName("name").item(0).getAttributes().getNamedItem("intent");
						int intent = Integer.parseInt(nEntity.getNodeValue());
						intent += 1;
						nEntity.setNodeValue(String.valueOf(intent));

						if (type != ElementCD.ATTRIBUTE && type != ElementCD.METHOD) {
							NodeList nListRelations = eElementClass.getElementsByTagName("relations");
							if (nListRelations.getLength() > 0 ) {
								Node nNodeRelation = nListRelations.item(0);
								if (nNodeRelation.getNodeType() == Node.ELEMENT_NODE) {
									Element eElementRelation = (Element) nNodeRelation;
									for (int index = 0; index < eElementRelation.getElementsByTagName(sType).getLength(); index++) {
										if (element.equals(eElementRelation.getElementsByTagName(sType).item(index).getTextContent())) {
											Node nToUpdate = eElementRelation.getElementsByTagName(sType).item(index).getAttributes().getNamedItem("intent");
											int val = Integer.parseInt(nToUpdate.getNodeValue());
											val += 1;
											nToUpdate.setNodeValue(String.valueOf(val));
											exist = true;
											break;
										}

									}
									if (!exist) {
										Element newElement = doc.createElement(sType);
										newElement.appendChild(doc.createTextNode(element));
										newElement.setAttribute("intent", "1");
										eElementRelation.appendChild(newElement);
										eElementClass.appendChild(eElementRelation);
									}

								}
							} else {
								Element eElementRelation = doc.createElement("relations");
								Element newElement = doc.createElement(sType);
								newElement.appendChild(doc.createTextNode(element));
								newElement.setAttribute("intent", "1");
								eElementRelation.appendChild(newElement);
								eElementClass.appendChild(eElementRelation);
							}
						} else {
							for (int index = 0; index < eElementClass.getElementsByTagName(sType).getLength(); index++) {
								if (element.equals(eElementClass.getElementsByTagName(sType).item(index).getTextContent())) {
									Node nToUpdate = eElementClass.getElementsByTagName(sType).item(index).getAttributes().getNamedItem("intent");
									int val = Integer.parseInt(nToUpdate.getNodeValue());
									val += 1;
									nToUpdate.setNodeValue(String.valueOf(val));
									exist = true;
									break;
								}
							}
							if (!exist) {
								Element eMethod = doc.createElement(sType);
								eMethod.setAttribute("intent", "1");
								eMethod.appendChild(doc.createTextNode(element));
								eElementClass.appendChild(eMethod);
							}
						}
						updated = true;
						break; 
					}
				}
			}
			
			if (updated) {
				TransformerFactory transformerFactory = TransformerFactory
	                    .newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
		        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ClassDiagram.dtd");
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fXmlFile);
	            transformer.transform(source, result);
			}
            
		} catch (Exception e) {
	    	e.printStackTrace();
		}
		return updated;
	}
	
	public Boolean createOrUpdateClassDiagram(String className, String element, ElementCD type) {
		Boolean response = true;
		response = this.updateClassDiagram(className, element, type);
		if (!response) {
			response = this.createClassDiagram(className, element, type);
		}
		return response;
	}
}
