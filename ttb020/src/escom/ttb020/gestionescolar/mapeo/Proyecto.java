package escom.ttb020.gestionescolar.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Entity
@Table(name = "ge07_proyecto")
public class Proyecto {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_proyecto")
	private Integer id;

	/**
	 * 
	 */
	@Column(name = "nb_proyecto")
	private String nombre;

	/**
	 * 
	 */
	@Column(name = "id_grupo")
	private Integer idGrupo;
	
	@ManyToOne
	@JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", insertable = false, updatable = false)
	private Grupo grupo;
	
	@OneToMany(mappedBy = "proyecto")
	private List<Diagrama> diagramas;

	/**
	 * 
	 */
	public Proyecto() {
		super();
	}

	/**
	 * @param idGrupo
	 */
	public Proyecto(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	@Validations(requiredFields = {
			@RequiredFieldValidator(message = "Campo Obligatorio", type = ValidatorType.FIELD, fieldName="model.nombre") })
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	@Validations(intRangeFields = {
			@IntRangeFieldValidator(message = "Campo Obligatorio", type = ValidatorType.FIELD, min = "1", fieldName="model.idGrupo") })
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Diagrama> getDiagramas() {
		return diagramas;
	}

	public void setDiagramas(List<Diagrama> diagramas) {
		this.diagramas = diagramas;
	}

}
