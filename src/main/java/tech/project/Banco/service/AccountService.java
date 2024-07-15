package tech.project.Banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.project.Banco.dtos.AccountDTO;
import tech.project.Banco.dtos.UpdateAccountDTO;
import tech.project.Banco.exception.ErrorResponse;
import tech.project.Banco.exception.GlobalExceptionHandler;
import tech.project.Banco.model.Account;
import tech.project.Banco.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<Account> create(AccountDTO dto) {
        Account account = new Account(dto);
        account.setAccountNumber(accountNumber());
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Account>> find() {
        List<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Account> findByObjectId(String id) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(()
                -> new Exception("Account not found with ID provided"));
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<?> updateAccount(String id, UpdateAccountDTO dto) throws Exception {
            Account account = accountRepository.findById(id).orElseThrow(()
                    -> new Exception("Account not found with ID provided"));
            if(account != null) {
                if(matchesPassword(dto.getCurrentPassword(), account.getPassword())) {
                    account.setFirstName(dto.getFirstName());
                    account.setLastName(dto.getLastName());
                    account.setPassword(passwordEncoder.encode(dto.getNewPassword()));
                    accountRepository.save(account);
                    return new ResponseEntity<>(account, HttpStatus.OK);
                }
                return new ResponseEntity<>("The password entered is invalid", HttpStatus.FORBIDDEN);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteAccount(String id) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(()
                -> new Exception("Account not found with ID provided"));
        if(account != null) {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Long accountNumber() {
        var accountNumber = accountRepository.findAll().size();
        return (long) accountNumber+1;
    }

    private boolean matchesPassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
