package com.fagnerdev.deliverysystemeveris.config;

import java.time.Instant;
import java.util.Arrays;

import com.fagnerdev.deliverysystemeveris.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fagnerdev.deliverysystemeveris.entities.enums.MetodoPagamento;
import com.fagnerdev.deliverysystemeveris.entities.enums.StatusPedido;
import com.fagnerdev.deliverysystemeveris.repositories.ClienteRepository;
import com.fagnerdev.deliverysystemeveris.repositories.ItemPedidoRepository;
import com.fagnerdev.deliverysystemeveris.repositories.PedidoRepository;
import com.fagnerdev.deliverysystemeveris.repositories.ProdutoRepository;

/**
 * Classe  criada para testar as funções da API e popular (Seeding) o banco  de dados
 *
 * @author Fagner Cristino
 *
 */


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Produto produto1 = new Produto(null, "TV Smart 50'", 2500.00);
		Produto produto2 = new Produto(null, "Chuveiro", 250.00);
		Produto produto3 = new Produto(null, "Iphone X12", 12500.00);
		Produto produto4 = new Produto(null, "NoteBook Dell", 63200.00);
		Produto produto5 = new Produto(null, "Livro O Senhor dos aneis", 150.00);
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Cliente c1 = new Cliente(null, "Maria Brown", "45645786546", "maria@gmail.com", "123456", "servidao da felicidade 1048");
		Cliente c2 = new Cliente(null, "Alex Green", "48998368957", "alex@gmail.com", "123456", "marcus aurelio homem 259");
		Cliente c3 = new Cliente(null, "Alberto Dias", "789632565", "alberto@gmail.com", "789653265", "Lauro Lonhares 1048");


		Pedido p1 = new Pedido(null, Instant.parse("2021-02-07T19:53:07Z"), StatusPedido.PREPARANDO, c1, produto1);
		Pedido p2 = new Pedido(null, Instant.parse("2021-01-29T02:33:18Z"), StatusPedido.ENVIADO, c2, produto2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.ENTREGADO, c3, produto3);

		
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemPedido ip1 = new ItemPedido(p3, produto5, 2, produto5.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, produto3, 1, produto3.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, produto3, 3, produto3.getPreco());

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		Payments pag1 = new Payments(null, Instant.parse("2021-02-07T20:30:33Z"),  p1, MetodoPagamento.CREDITO);
		Payments pag2 = new Payments(null, Instant.parse("2021-01-30T02:33:18Z"),  p2, MetodoPagamento.DEBITO);
		Payments pag3 = new Payments(null, Instant.parse("2019-06-22T08:15:07Z"),  p3, MetodoPagamento.DINHEIRO);

		
		
		p1.setPagamento(pag1);
		p2.setPagamento(pag2);
		p3.setPagamento(pag3);

		
		pedidoRepository.save(p1);
		pedidoRepository.save(p2);
		pedidoRepository.save(p3);




		
		
		
		

	}
	
	

}
