package br.com.beer.webflux.beerwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.com.beer.webflux.beerwebflux.domain.Beer;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Long> {

}
