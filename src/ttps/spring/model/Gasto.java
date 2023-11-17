package ttps.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "gastos")
public class Gasto {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="monto")
	private double monto;
	
	@Column(name="fecha")
	private LocalDate fechaGasto;
	
	@ManyToOne
    @JoinColumn(name = "grupoId")
	private Grupo grupo;

	@ManyToOne()
    @JoinColumn(name = "formaDivisionId")
	private FormaDivision formaDivision;
	
	@ManyToOne
    @JoinColumn(name = "usuarioId")
	private Usuario usuarioGasto;
	
	@ManyToOne()
    @JoinColumn(name = "imgId")
	private Imagen img;
	
	@ManyToMany(mappedBy = "saldoUsuario")
	private List<SaldoPorPersona> saldosUsuario;
	
	@ManyToOne()
    @JoinColumn(name = "categoriaGastoId")
	private CategoriaGasto categoriaGasto;

	public Gasto () {
		
	}
	public Gasto(Long id, String nombre, double monto, LocalDate fechaGasto, FormaDivision formaDivision, Usuario usuarioGasto, Imagen img, List<SaldoPorPersona> saldosUsuario, CategoriaGasto categoriaGasto) {
		this.id = id;
		this.nombre = nombre;
		this.monto = monto;
		this.fechaGasto = fechaGasto;
		this.formaDivision = formaDivision;
		this.usuarioGasto = usuarioGasto;
		this.img = img;
		this.saldosUsuario = saldosUsuario;
		this.categoriaGasto = categoriaGasto;
	}
	
	public Gasto( String nombre, double monto, LocalDate fechaGasto, FormaDivision formaDivision, Usuario usuarioGasto, Imagen img, CategoriaGasto categoriaGasto) {
		this.nombre = nombre;
		this.monto = monto;
		this.fechaGasto = fechaGasto;
		this.formaDivision = formaDivision;
		this.usuarioGasto = usuarioGasto;
		this.img = img;
		this.categoriaGasto = categoriaGasto;
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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDate getFechaGasto() {
		return fechaGasto;
	}

	public void setFechaGasto(LocalDate fechaGasto) {
		this.fechaGasto = fechaGasto;
	}

	public FormaDivision getFormaDivision() {
		return formaDivision;
	}

	public void setFormaDivision(FormaDivision formaDivision) {
		this.formaDivision = formaDivision;
	}

	public Usuario getUsuarioGasto() {
		return usuarioGasto;
	}

	public void setUsuarioGasto(Usuario usuarioGasto) {
		this.usuarioGasto = usuarioGasto;
	}

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}

	public List<SaldoPorPersona> getSaldosUsuario() {
		return saldosUsuario;
	}

	public void setSaldosUsuario(List<SaldoPorPersona> saldosUsuario) {
		this.saldosUsuario = saldosUsuario;
	}

	public CategoriaGasto getCategoriaGasto() {
		return categoriaGasto;
	}

	public void setCategoriaGasto(CategoriaGasto categoriaGasto) {
		this.categoriaGasto = categoriaGasto;
	}

	public void asignarSaldoPorPersona(Usuario unUsuario, double unSaldo){}

	private void asignarSaldoPorGrupoPersonas(List<Usuario> unGrupo, double unSaldo){}

	private void asignarSaldoPorGrupoPersonas(List<Usuario> unGrupo){}
}
