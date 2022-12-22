package com.bootcamp.java.pasivocuentacorriente.controller;

import com.bootcamp.java.pasivocuentacorriente.dto.TransactionDTO;
import com.bootcamp.java.pasivocuentacorriente.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pasivocuentacorriente/externalTransaction")
public class externalTransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{IdProductClient}")
    public Mono<ResponseEntity<TransactionDTO>> createTrxEntrada(@PathVariable String IdProductClient,
                                                                 @Valid @RequestBody TransactionDTO transactionDTO) {
        log.info("create transactionDTO executed {}", transactionDTO);
        return transactionService.registerTrxEntradaExterna(transactionDTO, IdProductClient)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
