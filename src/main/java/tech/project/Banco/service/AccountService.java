package tech.project.Banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.project.Banco.dto.AccountDTO;
import tech.project.Banco.model.Account;
import tech.project.Banco.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<Account> gerarConta(AccountDTO dto) {
        Account account = new Account(dto);
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
