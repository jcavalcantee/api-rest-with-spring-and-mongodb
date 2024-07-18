package tech.project.Banco.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import tech.project.Banco.dtos.TransactionDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Transaction {

    @Id
    private String id;
    private BigDecimal amount;
    private String sender;
    private String receiver;
    private LocalDateTime timeStamp;

    public Transaction(TransactionDTO dto) {
        this.sender = dto.getSender();
        this.receiver = dto.getReceiver();
        this.amount = dto.getAmount();
        this.timeStamp = dto.getTimeStamp();
    }
}
