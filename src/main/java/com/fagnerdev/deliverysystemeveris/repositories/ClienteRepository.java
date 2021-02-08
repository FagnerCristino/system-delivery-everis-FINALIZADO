package com.fagnerdev.deliverysystemeveris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagnerdev.deliverysystemeveris.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
