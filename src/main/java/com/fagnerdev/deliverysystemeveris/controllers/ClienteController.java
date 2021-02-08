package com.fagnerdev.deliverysystemeveris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fagnerdev.deliverysystemeveris.entities.Cliente;
import com.fagnerdev.deliverysystemeveris.services.ClienteService;

/**
 * Classe onde mapeamos e configuramos todas as funções e métodos associadas à entidade Cliente
 */

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> list = clienteService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById( @PathVariable Long id){
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
		obj = clienteService.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){

		clienteService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj){
		obj = clienteService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}


}
