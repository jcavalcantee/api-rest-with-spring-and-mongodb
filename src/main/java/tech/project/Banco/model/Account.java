package tech.project.Banco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.project.Banco.dtos.AccountDTO;
import tech.project.Banco.dtos.UpdateAccountDTO;
import tech.project.Banco.model.enums.AccountStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Account {

    @Id
    private String id;
    private Long accountNumber;
    private String firstName;
    private String lastName;
    private String password;
    private BigDecimal balance;
    private AccountStatus accountStatus;
    private LocalDateTime openingDate;

    public Account(AccountDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.password = encryptPassword(dto.getPassword());
        this.balance = BigDecimal.ZERO;
        this.setAccountStatus(AccountStatus.ACTIVE);
        this.openingDate = LocalDateTime.now();
    }

    public Account(UpdateAccountDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.password = dto.getCurrentPassword();
    }

    public String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

}
