package com.fagnerdev.deliverysystemeveris.services;

import java.util.List;
import java.util.Optional;

import com.fagnerdev.deliverysystemeveris.entities.Cliente;
import com.fagnerdev.deliverysystemeveris.services.exceptions.ControllerNotFoundException;
import com.fagnerdev.deliverysystemeveris.services.exceptions.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fagnerdev.deliverysystemeveris.entities.Produto;
import com.fagnerdev.deliverysystemeveris.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}

	public void delete(Long id){
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);//exceção quando na requisição DELETE um id não é encontrado
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());

		}
	}

	public Produto update(Long id, Produto obj){
		Produto entity = produtoRepository.getOne(id);
		updateData(entity, obj);
		return produtoRepository.save(entity);

	}

	private void updateData(Produto entity, Produto obj) {
		entity.setNome(obj.getNome());
		entity.setPreco(obj.getPreco());

	}

}
