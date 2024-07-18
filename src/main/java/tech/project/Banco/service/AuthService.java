package tech.project.Banco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.project.Banco.dtos.UserDTO;
import tech.project.Banco.model.UserModel;
import tech.project.Banco.repository.UserRepository;
import tech.project.Banco.security.TokenService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseEntity<?> authentication(UserDTO dto) {
        UserModel user = userRepository.findByUsername(dto.getUsername()).orElseThrow
                (()-> new UsernameNotFoundException("User not found"));
        if(passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
