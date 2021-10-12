package br.com.alura.spring.data.orm;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer agencia;
	private Integer numero;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "TITULAR_ID", nullable = false)
	private List<Cliente> titular;
	@Column(name = "SALDO")
	private BigDecimal saldo;
	@Column(name = "SINCE")
	private LocalDateTime dtAbertura;

	public Long getId() {
		return id;
	}

	public LocalDateTime getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(LocalDateTime dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Cliente> getTitular() {
		return titular;
	}

	public void setTitular(List<Cliente> titular) {
		this.titular = titular;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, id, numero, saldo, titular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(titular, other.titular);
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", numero=" + numero + ", titular=" + titular + ", saldo="
				+ saldo + "]";
	}

}
