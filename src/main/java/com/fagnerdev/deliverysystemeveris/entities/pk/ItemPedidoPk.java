package com.fagnerdev.deliverysystemeveris.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fagnerdev.deliverysystemeveris.entities.Pedido;
import com.fagnerdev.deliverysystemeveris.entities.Produto;

/**
 * 
 *  * Classe que representa uma chave composta
 *  
 *  
 * No paradigma orientado a objetos não temos o conceito de chave primaria composta,
 * por isso criamos uma classe auxiliar para representar o par de chaves primarias.
 * 
 * Isso porque o par Pedido/Produto (ItemPedidoPk) vai representar a chave da classe ItemPedido.
 * 
 * Por isso criamos esta classe auxiliar ItemPedidoPk, classe que referencia as duas classes (e suas respectivas chaves)
 * 

 * 
 * @author fcristid
 *
 */

@Embeddable
public class ItemPedidoPk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public ItemPedidoPk() {
		
	}

	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoPk other = (ItemPedidoPk) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	

}
