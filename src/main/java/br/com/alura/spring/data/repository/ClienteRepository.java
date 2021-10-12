package br.com.alura.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.spring.data.orm.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
