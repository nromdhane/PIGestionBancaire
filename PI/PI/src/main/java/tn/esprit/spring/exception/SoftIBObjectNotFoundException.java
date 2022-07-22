package tn.esprit.spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SoftIBObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -245914076167801121L;

    public SoftIBObjectNotFoundException() {
        super();
    }

    public SoftIBObjectNotFoundException(String message) {
        super(message);
    }

}