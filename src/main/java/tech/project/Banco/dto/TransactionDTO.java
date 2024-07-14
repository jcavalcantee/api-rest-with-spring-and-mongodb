package tech.project.Banco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TransactionDTO {

    private BigDecimal amount;
    private String sender;
    private String receiver;
    private LocalDateTime timeStamp;
}
