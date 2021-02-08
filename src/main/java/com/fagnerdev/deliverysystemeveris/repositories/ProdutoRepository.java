package com.fagnerdev.deliverysystemeveris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagnerdev.deliverysystemeveris.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
