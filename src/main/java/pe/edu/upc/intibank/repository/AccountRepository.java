package pe.edu.upc.intibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.intibank.entity.Account;
import pe.edu.upc.intibank.entity.User;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByCardNumber(String cardNumber);

    List<Account> findAllByUser(User user);

    Optional<Account> findByCardNumber(String cardNumber);

    Optional<Account> findByCardNumberAndCvv(String cardNumber, String cvv);

    Optional<Account> findById(Long id);

}
