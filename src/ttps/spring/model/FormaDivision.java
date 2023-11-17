package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "formasDivision")
public class FormaDivision {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
    
	@Column(name="descripcion")
	private String descripcion;

	public FormaDivision() {
		
	}
    public FormaDivision(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public FormaDivision(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
