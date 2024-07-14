package tech.project.Banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.project.Banco.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
}
