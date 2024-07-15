package tech.project.Banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import tech.project.Banco.dtos.AccountDTO;
import tech.project.Banco.dtos.UpdateAccountDTO;
import tech.project.Banco.model.Account;
import tech.project.Banco.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO dto) {
        return accountService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return accountService.find();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findByObjectId(@PathVariable String id) throws Exception {
        return accountService.findByObjectId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable String id, @RequestBody UpdateAccountDTO dto) throws Exception {
        return accountService.updateAccount(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) throws Exception {
        return accountService.deleteAccount(id);
    }
}
