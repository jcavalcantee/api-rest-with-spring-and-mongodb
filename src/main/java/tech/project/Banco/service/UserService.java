package tech.project.Banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.project.Banco.dtos.UserDTO;
import tech.project.Banco.model.UserModel;
import tech.project.Banco.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserModel> create(UserDTO dto) {
        UserModel userModel = new UserModel(dto);
        userRepository.save(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}
