package br.com.beer.webflux.beerwebflux.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    private Long id;
    private String name;
    private BeerType type;
    private BigDecimal value;
    private Double content;

    @Column("url_image")
    private String urlImage;
}
