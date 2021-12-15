package br.com.beer.webflux.beerwebflux.service;

import org.springframework.stereotype.Service;

import br.com.beer.webflux.beerwebflux.domain.Beer;
import br.com.beer.webflux.beerwebflux.mapper.BeerMapper;
import br.com.beer.webflux.beerwebflux.repository.BeerRepository;
import br.com.beer.webflux.beerwebflux.request.BeerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;
    private final FileUploadService fileUploadService;

    public Flux<Beer> find() {
        return beerRepository.findAll();
    }

    public Mono<Beer> save(final BeerRequest request) {
        return fileUploadService.execute(request.getImage())
            .flatMap(urlImage -> {
                Beer beer = new BeerMapper().apply(request);
                beer.setUrlImage(urlImage);

                return beerRepository.save(beer);
            });
    }
}
