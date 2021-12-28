package br.com.beer.webflux.beerwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beer.webflux.beerwebflux.response.MemoryStatsResponse;

@RestController
@RequestMapping(value = "/memory-status", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemoryController {

    @GetMapping()
    public MemoryStatsResponse getMemoryStatistics() {
        return MemoryStatsResponse.builder()
            .heapSize(Runtime.getRuntime().totalMemory())
            .heapMaxSize(Runtime.getRuntime().maxMemory())
            .heapFreeSize(Runtime.getRuntime().freeMemory())
            .build();
    }
}
