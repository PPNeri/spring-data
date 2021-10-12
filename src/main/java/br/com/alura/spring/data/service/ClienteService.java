package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	public ClienteService(ClienteRepository repository) {
		super();
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {
		
	}

}
