package com.fagnerdev.deliverysystemeveris.services;


import com.fagnerdev.deliverysystemeveris.entities.ItemPedido;
import com.fagnerdev.deliverysystemeveris.repositories.ItemPedidoRepository;
import com.fagnerdev.deliverysystemeveris.services.exceptions.ControllerNotFoundException;
import com.fagnerdev.deliverysystemeveris.services.exceptions.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public List<ItemPedido> findAll(){
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido findById(Long id) {
		Optional<ItemPedido> obj = itemPedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id)); //exceção quando na requesição GET um id não é encontrado
	}
	
	public ItemPedido insert(ItemPedido obj) {
		return itemPedidoRepository.save(obj);
	}

	public void delete(Long id){
		try {
			itemPedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);//exceção quando na requisição DELETE um id não é encontrado
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());

		}
	}

	public ItemPedido update(Long id, ItemPedido obj) throws ControllerNotFoundException {

		try{
			ItemPedido entity = itemPedidoRepository.getOne(id);
			updateData(entity, obj);
			return itemPedidoRepository.save(entity);
		}catch (EntityNotFoundException e){
			throw new ControllerNotFoundException(id);
		}


	}

	private void updateData(ItemPedido entity, ItemPedido obj) {
		entity.setPedido(obj.getPedido());
		entity.setProduto(obj.getProduto());
		entity.setPreco(obj.getPreco());
		entity.setQuantidade(obj.getQuantidade());
	}

}
