package com.fagnerdev.deliverysystemeveris.entities;

import java.time.Instant;

import javax.persistence.*;

import com.fagnerdev.deliverysystemeveris.entities.enums.MetodoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe onde salvamos os dados do pagamento e o associamos à um pedido
 *
 * @author Fagner Cristino
 */

@Entity
@Table(name = "tb_payments")
public class Payments {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;

	@Enumerated
	private MetodoPagamento metodoPagamento;

	/**
	 * Associação de mão dupla. Utilizamos esta anotação (@JsonIgnore)
	 * para evtitar que a requisição fique presa num looping infinito.
	 */
	@JsonIgnore
	@OneToOne
	private Pedido pedido;
	
	
	public Payments () {
		
	}

	public Payments(Long id, Instant moment, Pedido pedido, MetodoPagamento metodoPagamento) {
		super();
		this.id = id;
		this.moment = moment;
		this.pedido = pedido;
		this.metodoPagamento = metodoPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}
	
	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payments other = (Payments) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
