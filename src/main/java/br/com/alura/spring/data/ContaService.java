package br.com.alura.spring.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cliente;
import br.com.alura.spring.data.orm.Conta;
import br.com.alura.spring.data.repository.ClienteRepository;
import br.com.alura.spring.data.repository.ContaRepository;

@Service
public class ContaService {

	private Boolean system = true;
	private final ContaRepository repository;
	private final ClienteRepository clienteRepository;

	public ContaService(ContaRepository repository, ClienteRepository clienteRepository) {
		super();
		this.repository = repository;
		this.clienteRepository = clienteRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("O que deseja ?");
			System.out.println("1-Visulaizar");
			System.out.println("2-Cadastrar nova conta");
			System.out.println("0-Sair");

			int op = scanner.nextInt();

			switch (op) {
			case 1:
				visualizarTodasAsContas();
				break;
			case 2:
				cadastrarNovaConta(scanner);
				break;

			default:
				system = false;
				break;
			}

		}

	}

	private void visualizarTodasAsContas() {
		List<Conta> contas = repository.findAll();
		contas.forEach(conta -> System.out.println(contas));
	}

	private void cadastrarNovaConta(Scanner scanner) {

		Conta c = new Conta();
		LocalDateTime today = LocalDateTime.now();
		c.setDtAbertura(today);
		
		int numeroGerado = gerarNumeroConta(1000, 9999);
		
		validaContaByNumber(numeroGerado);
		
		c.setNumero(numeroGerado);
		
		System.out.println("Digite a agencia com 4 Digitos");
		int agencia = scanner.nextInt();
		c.setAgencia(agencia);
		List<Cliente> clientes = clienteRepository.findAll();
		System.out.println("Digite o  titular");
		int idTitular = scanner.nextInt();
		
		System.out.println();
		c.setTitular(null);

	}

	private void validaContaByNumber(int numeroGerado) {
		Conta conta = repository.findByNumero(numeroGerado);
		while (conta != null) {
			numeroGerado = gerarNumeroConta(1000, 9999);
			conta = repository.findByNumero(numeroGerado);

		}
	}

	public int gerarNumeroConta(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
