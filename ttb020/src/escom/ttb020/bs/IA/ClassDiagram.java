package escom.ttb020.bs.IA;
import java.util.ArrayList;
import java.util.Comparator;

public class ClassDiagram {
	private String name;
	private String intent;
	private ArrayList<CDElement> attributes;
	private ArrayList<CDElement> methods;
	private ArrayList<CDElement> inheritance;
	private ArrayList<CDElement> association;
	private ArrayList<CDElement> aggregation;
	private ArrayList<CDElement> composition;
	private ArrayList<CDElement> dependency;
	
	public static Comparator<CDElement> comparador = new Comparator<CDElement>() {
		public int compare(CDElement r1, CDElement r2) {
			
			String relacionIntento1 = r1.getIntent().toLowerCase();
			String relacionIntento2 = r2.getIntent().toLowerCase();
			
			return relacionIntento1.compareTo(relacionIntento2);
		}
	};
    
    public ClassDiagram() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public ArrayList<CDElement> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<CDElement> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<CDElement> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<CDElement> methods) {
		this.methods = methods;
	}

	public ArrayList<CDElement> getInheritance() {
		return inheritance;
	}

	public void setInheritance(ArrayList<CDElement> inheritance) {
		this.inheritance = inheritance;
	}

	public ArrayList<CDElement> getAssociation() {
		return association;
	}

	public void setAssociation(ArrayList<CDElement> association) {
		this.association = association;
	}

	public ArrayList<CDElement> getAggregation() {
		return aggregation;
	}

	public void setAggregation(ArrayList<CDElement> aggregation) {
		this.aggregation = aggregation;
	}

	public ArrayList<CDElement> getComposition() {
		return composition;
	}

	public void setComposition(ArrayList<CDElement> composition) {
		this.composition = composition;
	}

	public ArrayList<CDElement> getDependency() {
		return dependency;
	}

	public void setDependency(ArrayList<CDElement> dependency) {
		this.dependency = dependency;
	}
    
}
