package tech.project.Banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.project.Banco.dto.AccountDTO;
import tech.project.Banco.model.Account;
import tech.project.Banco.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO dto) {
        return accountService.gerarConta(dto);
    }
}
