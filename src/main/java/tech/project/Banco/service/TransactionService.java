package tech.project.Banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.project.Banco.dto.TransactionDTO;
import tech.project.Banco.model.Account;
import tech.project.Banco.model.Transaction;
import tech.project.Banco.repository.AccountRepository;
import tech.project.Banco.repository.TransactionRepository;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<Transaction> doTransaction(TransactionDTO dto) throws Exception{
        Account sender = accountRepository.findById(String.valueOf(dto.getSender()))
                .orElseThrow(()-> new Exception("sender error"));
        Account receiver = accountRepository.findById(String.valueOf(dto.getReceiver()))
                .orElseThrow(()-> new Exception("receiver error"));

        Transaction transaction = new Transaction();
        if(sender.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new Error("insufficient balance");
        }

        transaction.setSender(dto.getSender());
        transaction.setReceiver(dto.getReceiver());
        transaction.setAmount(dto.getAmount());
        transaction.setTimeStamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        sender.setBalance(sender.getBalance().subtract(dto.getAmount()));
        receiver.setBalance(receiver.getBalance().add(dto.getAmount()));
        accountRepository.save(sender);
        accountRepository.save(receiver);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
