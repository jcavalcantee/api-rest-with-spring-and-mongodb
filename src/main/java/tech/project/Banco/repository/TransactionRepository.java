package tech.project.Banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.project.Banco.model.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
