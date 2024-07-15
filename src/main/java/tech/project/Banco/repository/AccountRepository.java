package tech.project.Banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.project.Banco.model.Account;
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}
