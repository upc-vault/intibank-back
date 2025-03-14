package pe.edu.upc.intibank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String dni;

    @Column(nullable = false)
    private Double amount_loan;

    @Column(nullable = false)
    private Double interest_rate;

    @Column(nullable = false)
    private Integer months;

    @Column(nullable = false)
    private Date date_loan_start;
}
