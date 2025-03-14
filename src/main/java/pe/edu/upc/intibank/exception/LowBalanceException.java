package pe.edu.upc.intibank.exception;

import pe.edu.upc.intibank.entity.Transaction;

public class LowBalanceException extends RuntimeException {
    public LowBalanceException(Transaction transaction) {
        super();
    }

    public LowBalanceException(String message) {
        super(message);
    }
}

