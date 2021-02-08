package com.fagnerdev.deliverysystemeveris.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fagnerdev.deliverysystemeveris.entities.pk.ItemPedidoPk;

import java.io.Serializable;

/**
 * Classe onde guardamos os items dos produtos selecionados pelo cliente
 *
 * Esta classe tem a peculiaridade de que o id é outra classe formando uma
 * chave composta onde nela são guardados o id do produto e do pedido
 * 
 * @author fcristid
 *
 */


@Entity
@Table(name = "tb_item_pedido")

public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk(); // instanciamos um objeto da classe para que os atributos das classes das duas chaves primarias possam ser associados
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
