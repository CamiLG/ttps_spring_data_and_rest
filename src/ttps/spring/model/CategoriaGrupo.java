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
@Table(name= "categoriasGrupo")
public class CategoriaGrupo {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombreGrupo;

	@ManyToOne()
    @JoinColumn(name = "imgId")
	private Imagen img;

	public CategoriaGrupo(Long id, String nombreGrupo, Imagen img) {
		this.id = id;
		this.nombreGrupo = nombreGrupo;
		this.img = img;
	}
	
	public CategoriaGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}
}
