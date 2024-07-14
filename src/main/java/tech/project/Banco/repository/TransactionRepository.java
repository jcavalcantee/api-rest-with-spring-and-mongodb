package tech.project.Banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.project.Banco.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
