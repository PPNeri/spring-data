package br.com.alura.spring.data.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.spring.data.orm.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query("SELECT c FROM Country c where c.name =:name and c.indepYear >= :indepYear")
	List<Country> findByNameAndIndepYear(String name, Integer indepYear);

	@Query("SELECT c FROM Country c where c.indepYear >= :indepYear")
	List<Country> findIndepYearByYear(int indepYear);

	List<Country> findByGnpGreaterThanEqual(BigDecimal gnp);

}
