package escom.ttb020.bs.IA;

import java.util.Comparator;

public class RelationUC{
	private String intent;
	private String name;
	
	public static Comparator<RelationUC> comparador = new Comparator<RelationUC>() {
		public int compare(RelationUC r1, RelationUC r2) {
			
			String relacionIntento1 = r1.getIntent().toLowerCase();
			String relacionIntento2 = r2.getIntent().toLowerCase();
			
			return relacionIntento1.compareTo(relacionIntento2);
		}
	};
	
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

}
