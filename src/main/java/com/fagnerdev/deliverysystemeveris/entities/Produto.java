package com.fagnerdev.deliverysystemeveris.entities;

import java.util.List;

import javax.persistence.*;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Classe que represetna a entidade Produto
 * Aqui declaramos os atributos e a associamos à um cliente e a uma lista de pedidos
 *
 * @author Fagner Cristino
 */
@Entity
@Table(name = "tb_produto")
@RequestMapping(value = "/produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.produto", cascade = CascadeType.PERSIST)
	private List<ItemPedido> items;
	
	public Produto () {
		
	}

	public Produto(Long id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
