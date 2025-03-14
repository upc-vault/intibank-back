package pe.edu.upc.intibank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseModel{
    private HttpStatus status;
    private boolean success;
    private Object data;
    private Object errors;
    private String message; //#Chris


    public ResponseModel() {
    }

    public ResponseModel(HttpStatus status, boolean success, Object data, Object error, String message) {
        this.status = status;
        this.success = success;
        this.data = data;
        this.errors = error;
        this.message = message;
    }

    public ResponseModel(String message) {
        this.message = message;
    }

}



