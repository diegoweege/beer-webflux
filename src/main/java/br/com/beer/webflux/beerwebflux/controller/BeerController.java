package br.com.beer.webflux.beerwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beer.webflux.beerwebflux.domain.Beer;
import br.com.beer.webflux.beerwebflux.service.BeerService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    public Flux<Beer> findBeer() {
        return beerService.find();
    }
}
