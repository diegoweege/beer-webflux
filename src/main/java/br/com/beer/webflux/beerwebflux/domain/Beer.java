package br.com.beer.webflux.beerwebflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Beer {

    @Id
    private Long id;
    private String name;
    private BeerType type;
}
