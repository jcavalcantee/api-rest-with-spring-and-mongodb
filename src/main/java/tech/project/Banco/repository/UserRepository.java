package tech.project.Banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tech.project.Banco.model.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    @Query("{ 'username' : ?0 }")
    Optional<UserModel> findByUsername(String username);
}
