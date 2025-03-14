package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
