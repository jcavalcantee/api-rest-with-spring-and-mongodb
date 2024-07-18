package tech.project.Banco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.project.Banco.dtos.UserDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserModel {

    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public UserModel(UserDTO dto) {
        this.username = dto.getUsername();
        this.password = encryptPassword(dto.getPassword());
    }

    public String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
