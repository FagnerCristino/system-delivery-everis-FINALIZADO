package com.fagnerdev.deliverysystemeveris.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fagnerdev.deliverysystemeveris.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe onde associamos a classe Cliente à Classe Pedido e criamos uma lista com os itens (produtos) selecionados pelo cliente.
 * 
 *@author Fagner Cristino
 *
 */


@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// anotação para deixar o formato da data estandarizado no GMT timezone
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant momento;
	
	private StatusPedido statusPedido;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;


	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@OneToMany(mappedBy = "id.pedido", cascade = CascadeType.PERSIST)
	private Set<ItemPedido> items = new HashSet<>();
	
	/**
	 * Mapeando as duas entidades para que tenham o mesmo ID. 
	 * Exemplo: se o pedido for código "5", o pagamento também terá o mesmo código. E nesse caso de mapeamento 
	 * um para um, quando acontece isso, é obrigatório utilizar a anotação "CascadeType".
	 */
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Payments pagamento;

	public Pedido() {

	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, Cliente cliente) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = cliente;
		setStatusPedido(statusPedido);
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Payments getPagamento() {
		return pagamento;
	}

	public void setPagamento(Payments pagamento) {
		this.pagamento = pagamento;
	}

	// método que retorna os items selecionados
	public Set<ItemPedido> getItems(Cliente cliente){
		return items;
	}
	
	public Double getTotal() {
		double sum = 0;
		for (ItemPedido itemPedido : items) {
			sum += itemPedido.getSubTotal();
		}
		
		return sum;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
