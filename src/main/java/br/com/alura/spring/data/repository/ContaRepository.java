package br.com.alura.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.spring.data.orm.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findByNumero(Integer n);

}
