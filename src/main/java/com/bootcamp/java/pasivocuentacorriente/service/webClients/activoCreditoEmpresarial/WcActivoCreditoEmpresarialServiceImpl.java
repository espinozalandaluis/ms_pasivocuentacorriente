package com.bootcamp.java.pasivocuentacorriente.service.webClients.activoCreditoEmpresarial;

import com.bootcamp.java.pasivocuentacorriente.common.Constantes;
import com.bootcamp.java.pasivocuentacorriente.dto.ProductClientDTO;
import com.bootcamp.java.pasivocuentacorriente.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class WcActivoCreditoEmpresarialServiceImpl implements WcActivoCreditoEmpresarialService{

    private final WebClient wcActivoCreditoEmpresarial = WebClient.builder()
            .baseUrl(Constantes.WebClientUriMSActivoCreditoEmpresarial)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    private final WebClient wcActivoCreditoEmpresarialTrx = WebClient.builder()
            .baseUrl(Constantes.WebClientUriMSActivoCreditoEmpresarialTrx)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @Override
    public Mono<ProductClientDTO> findByAccountNumber(String accountNumber) {

        return wcActivoCreditoEmpresarial.get()
                .uri("/{accountNumber}" ,accountNumber)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NO_CONTENT.equals(httpStatus),
                        response -> response.bodyToMono(String.class)
                                .map(Exception::new))
                .bodyToMono(ProductClientDTO.class)
                .timeout(Duration.ofMillis(Constantes.TimeOutWebClients));
    }

    @Override
    public Mono<TransactionDTO> registerTrxEntradaExterna(TransactionDTO transactionDTO,
                                                          String IdProductClient) {
        return wcActivoCreditoEmpresarialTrx.post()
                .uri("/{IdProductClient}" ,IdProductClient)
                .body(Mono.just(transactionDTO), TransactionDTO.class)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NO_CONTENT.equals(httpStatus),
                        response -> response.bodyToMono(String.class)
                                .map(Exception::new))
                .bodyToMono(TransactionDTO.class)
                .timeout(Duration.ofMillis(Constantes.TimeOutWebClients));
    }

}
