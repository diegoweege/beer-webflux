package br.com.beer.webflux.beerwebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.beer.webflux.beerwebflux.request.UploadFile;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FileUploadService {

    @Autowired
    private WebClient webClient;

    public Mono<String> execute(final byte[] image) {
        final UploadFile uploadFile = UploadFile.builder()
            .file(image)
            .build();

        return webClient
            .post()
            .uri("file-upload/image")
            .bodyValue(uploadFile)
            .retrieve()
            .bodyToMono(String.class)
            .doOnSuccess(urlImage -> log.info("Upload realizado com sucesso. URL: {}", urlImage))
            .doOnError(e -> log.error("Erro ao chamar serviço de upload de arquivo", e))
            .onErrorReturn("");
    }
}
