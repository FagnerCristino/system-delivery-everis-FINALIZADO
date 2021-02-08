package com.fagnerdev.deliverysystemeveris.services;

import java.util.List;
import java.util.Optional;

import com.fagnerdev.deliverysystemeveris.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fagnerdev.deliverysystemeveris.entities.Pedido;
import com.fagnerdev.deliverysystemeveris.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public Pedido insert(Pedido obj) {
		return pedidoRepository.save(obj);
	}

	public void delete(Long id){
		pedidoRepository.deleteById(id);
	}
}
