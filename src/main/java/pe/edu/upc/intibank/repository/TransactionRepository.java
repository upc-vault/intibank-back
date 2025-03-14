package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
