package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "categoriasGasto")
public class CategoriaGasto {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombreGasto;

	@ManyToOne()
    @JoinColumn(name = "imgId")
	private Imagen img;

	public CategoriaGasto(Long id, String nombreGasto, Imagen img) {
		this.id = id;
		this.nombreGasto = nombreGasto;
		this.img = img;
	}
	public CategoriaGasto() {
		
	}
	public CategoriaGasto(String nombreGasto) {
		this.nombreGasto = nombreGasto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreGasto() {
		return nombreGasto;
	}

	public void setNombreGasto(String nombreGasto) {
		this.nombreGasto = nombreGasto;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}
}
