    package tech.project.Banco.model;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.springframework.data.annotation.Id;
    import tech.project.Banco.dto.AccountDTO;

    import java.math.BigDecimal;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter @Setter
    public class Account {

        @Id
        private String id;
        private String accountNumber;
        private String firstName;
        private String lastName;
        private BigDecimal balance;

        public Account(AccountDTO dto) {
            this.accountNumber = dto.getAccountNumber();
            this.firstName = dto.getFirstName();
            this.lastName = dto.getLastName();
            this.balance = dto.getBalance();
        }
    }
