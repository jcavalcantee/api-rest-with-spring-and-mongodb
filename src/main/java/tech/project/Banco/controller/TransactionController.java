package tech.project.Banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.project.Banco.dtos.TransactionDTO;
import tech.project.Banco.model.Transaction;
import tech.project.Banco.service.TransactionService;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> doTransaction(@RequestBody TransactionDTO dto) throws Exception {
        return transactionService.doTransaction(dto);
    }
}
