package br.com.beer.webflux.beerwebflux.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beer.webflux.beerwebflux.domain.Beer;
import br.com.beer.webflux.beerwebflux.domain.BeerType;
import br.com.beer.webflux.beerwebflux.request.BeerRequest;
import br.com.beer.webflux.beerwebflux.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    public Flux<Beer> find() {
        return beerService.find();
    }

    @PostMapping
    public Mono<Beer> save(@RequestBody Mono<BeerRequest> request) {
        return request
            .flatMap(req -> beerService.save(req));
    }
}
