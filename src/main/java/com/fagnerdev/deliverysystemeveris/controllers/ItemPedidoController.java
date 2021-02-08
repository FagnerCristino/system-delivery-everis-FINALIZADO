package com.fagnerdev.deliverysystemeveris.controllers;


import com.fagnerdev.deliverysystemeveris.entities.ItemPedido;
import com.fagnerdev.deliverysystemeveris.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe onde mapeamos e configuramos todas as funções e métodos associadas à entidade ItemPedido
 */

@RestController
@RequestMapping(value = "/item_pedido")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping
	public ResponseEntity <List<ItemPedido>> findAll(){
		List<ItemPedido> list = itemPedidoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> findById( @PathVariable Long id){
		ItemPedido obj = itemPedidoService.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}

	// Estes métodos foram implementados mas no funcionamento do sistema não são utilizados. Foram criados como teste e prática.
	
	@PostMapping
	public ResponseEntity<ItemPedido> insert(@RequestBody ItemPedido obj){
		obj = itemPedidoService.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){

		itemPedidoService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> update(@PathVariable Long id, @RequestBody ItemPedido obj){
		obj = itemPedidoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}


}
