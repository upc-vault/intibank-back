package pe.edu.upc.intibank.exception;

public class LowBalanceException extends RuntimeException {
    public LowBalanceException() {
        super();
    }

    public LowBalanceException(String message) {
        super(message);
    }
}

