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
@Table(name= "saldosPersona")
public class SaldoPorPersona {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="monto")
	private double monto;
	
	@ManyToOne
    @JoinColumn(name = "usuarioId")
	private Usuario saldoUsuario;

	public SaldoPorPersona(Long id, double monto, Usuario saldoUsuario) {
		this.id = id;
		this.monto = monto;
		this.saldoUsuario = saldoUsuario;
	}
	
	public SaldoPorPersona(double monto, Usuario saldoUsuario) {
		this.monto = monto;
		this.saldoUsuario = saldoUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Usuario getSaldoUsuario() {
		return saldoUsuario;
	}

	public void setSaldoUsuario(Usuario saldoUsuario) {
		this.saldoUsuario = saldoUsuario;
	}
}