package com.fagnerdev.deliverysystemeveris.services;

import java.util.List;
import java.util.Optional;

import com.fagnerdev.deliverysystemeveris.services.exceptions.ControllerNotFoundException;
import com.fagnerdev.deliverysystemeveris.services.exceptions.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.fagnerdev.deliverysystemeveris.entities.Cliente;
import com.fagnerdev.deliverysystemeveris.repositories.ClienteRepository;

import javax.persistence.EntityNotFoundException;

/***
 *
 * Classe onde implementamos os métodos que logo a classe ClienteController
 *
 * vai utilizar para enviar as informações ao banco de dados
 *
 * @author Fagner Cristino
 *
 */

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id)); //exceção quando na requesição GET um id não é encontrado
	}
	
	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}

	public void delete(Long id){
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);//exceção quando na requisição DELETE um id não é encontrado
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());

		}
	}

	public Cliente update(Long id, Cliente obj) throws ControllerNotFoundException {

		try{
			Cliente entity = clienteRepository.getOne(id);
			updateData(entity, obj);
			return clienteRepository.save(entity);
		}catch (EntityNotFoundException e){
			throw new ControllerNotFoundException(id);
		}


	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
	}

}
