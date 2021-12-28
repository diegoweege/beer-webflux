package br.com.beer.webflux.beerwebflux.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemoryStatsResponse {
    private long heapSize;
    private long heapMaxSize;
    private long heapFreeSize;
}
