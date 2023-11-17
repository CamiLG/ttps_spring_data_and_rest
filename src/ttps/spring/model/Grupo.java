package ttps.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "grupo_usuario", joinColumns = {
			@JoinColumn(name = "grupoId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "usuarioId", referencedColumnName = "id") })
	private Set<Usuario> integrantes;

	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
	private List<Gasto> gastosGrupo;

	@ManyToOne()
	@JoinColumn(name = "categoriaGrupoId")
	private CategoriaGrupo categoriaGrupo;

	public Grupo(Long id, String nombre, Set<Usuario> integrantes, List<Gasto> gastosGrupo,
			CategoriaGrupo categoriaGrupo) {
		this.id = id;
		this.nombre = nombre;
		this.integrantes = integrantes;
		this.gastosGrupo = gastosGrupo;
		this.categoriaGrupo = categoriaGrupo;
	}

	public Grupo(String nombre, Usuario integrante, Gasto gastoGrupo,
			CategoriaGrupo categoriaGrupo) {
		this.nombre = nombre;
		this.integrantes.add(integrante);
		this.gastosGrupo.add(gastoGrupo);
		this.categoriaGrupo = categoriaGrupo;
	}
	
	public Grupo(String nombre, CategoriaGrupo categoriaGrupo) {
		this.nombre = nombre;
		this.categoriaGrupo = categoriaGrupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(Set<Usuario> integrantes) {
		this.integrantes = integrantes;
	}

	public List<Gasto> getGastosGrupo() {
		return gastosGrupo;
	}

	public void setGastosGrupo(List<Gasto> gastosGrupo) {
		this.gastosGrupo = gastosGrupo;
	}

	public CategoriaGrupo getCategoriaGrupo() {
		return categoriaGrupo;
	}

	public void setCategoriaGrupo(CategoriaGrupo categoriaGrupo) {
		this.categoriaGrupo = categoriaGrupo;
	}

	public void agregarIntegrante(Usuario unIntegrante) {
	}
}
