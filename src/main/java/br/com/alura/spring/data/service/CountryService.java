package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Country;
import br.com.alura.spring.data.repository.CountryRepository;

@Service
public class CountryService {

	private Boolean system = true;

	private final CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {

			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
//			System.out.println("1 - Salvar");
//			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("5 - Buscar por nome e ano");
			System.out.println("6 - Buscar por Ano");
//			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;
			case 5:
				getCountryByNomeAndYear(scanner);
				break;
			case 6:
				getCountryByYear(scanner);
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Atualizado");
	}

	private void visualizar(Scanner scanner) {
		System.out.println("Qual pagina voce deseja visualizar");
		Integer page = scanner.nextInt();
		Instant inst1 = Instant.now();

		Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "population"));
		Page<Country> countries = countryRepository.findAll(pageable);

		System.out.println(countries);
		System.out.println("Pagina Atual " + countries.getNumber());
		System.out.println("Total de " + countries.getTotalElements());

		countries.forEach(e -> System.out.println(e));
		Instant inst2 = Instant.now();
		System.out.println(Duration.between(inst1, inst2).toString());
	}

	private void getCountryByNomeAndYear(Scanner scanner) {
		System.out.println("Nome");
		String name = scanner.next();
		System.out.println("Ano");
		Integer year = scanner.nextInt();

		List<Country> countries = countryRepository.findByNameAndIndepYear(name, year);
		System.out.println(countries);

	}

	private void getCountryByYear(Scanner scanner) {
		System.out.println("Ano");
		Integer year = scanner.nextInt();
		BigDecimal valueOf = BigDecimal.valueOf(year);

		List<Country> countries = countryRepository.findByGnpGreaterThanEqual(valueOf);
		countries.forEach(e -> System.out.println(e));

	}

	private void deletar(Scanner scanner) {
		System.out.println("Deletado");
	}

}
