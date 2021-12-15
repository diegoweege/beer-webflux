package br.com.beer.webflux.beerwebflux.mapper;

import java.util.function.Function;

import br.com.beer.webflux.beerwebflux.domain.Beer;
import br.com.beer.webflux.beerwebflux.request.BeerRequest;

public class BeerMapper implements Function<BeerRequest, Beer> {

    @Override
    public Beer apply(final BeerRequest request) {
        return Beer.builder()
            .name(request.getName())
            .type(request.getType())
            .content(request.getContent())
            .value(request.getValue())
            .build();
    }
}
