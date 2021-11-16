package br.com.beer.webflux.beerwebflux.service;

import org.springframework.stereotype.Service;

import br.com.beer.webflux.beerwebflux.domain.Beer;
import br.com.beer.webflux.beerwebflux.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    public Flux<Beer> find() {
        return beerRepository.findAll();
    }
}
