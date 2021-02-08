package com.fagnerdev.deliverysystemeveris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fagnerdev.deliverysystemeveris.entities.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
