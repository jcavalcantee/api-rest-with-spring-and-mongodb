package tech.project.Banco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AccountDTO {

    private String firstName;
    private String lastName;
    private String password;
}
