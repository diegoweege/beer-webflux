package br.com.beer.webflux.beerwebflux.request;

import java.math.BigDecimal;

import br.com.beer.webflux.beerwebflux.domain.BeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "image")
public class BeerRequest {

    private String name;
    private BeerType type;
    private BigDecimal value;
    private Double content;
    private byte[] image;

}
