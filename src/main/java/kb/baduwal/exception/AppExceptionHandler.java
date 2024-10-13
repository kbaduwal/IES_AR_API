package kb.baduwal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = SsaWebException.class)
    public ResponseEntity<AppException> handleSsaWebEx(SsaWebException ex){

        AppException appEx = new AppException();
        appEx.setExCode("EX0001");
        appEx.setExDec(ex.getMessage());
        appEx.setDate(LocalDate.now());

        return new ResponseEntity<AppException>(appEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
