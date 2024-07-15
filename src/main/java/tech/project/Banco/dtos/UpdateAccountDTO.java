package tech.project.Banco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UpdateAccountDTO {

    private String firstName;
    private String lastName;
    private String currentPassword;
    private String newPassword;
}
