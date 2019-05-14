package escom.ttb020.bs.IA;
import java.util.ArrayList;

public class UseCase{
	private String intent;
	private String entity;
	private ArrayList<RelationUC> rExtends;
	private ArrayList<RelationUC> rIncludes;
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public ArrayList<RelationUC> getrIncludes() {
		return rIncludes;
	}
	public void setrIncludes(ArrayList<RelationUC> rIncludes) {
		this.rIncludes = rIncludes;
	}
	public ArrayList<RelationUC> getrExtends() {
		return rExtends;
	}
	public void setrExtends(ArrayList<RelationUC> rExtends) {
		this.rExtends = rExtends;
	}
	

}
