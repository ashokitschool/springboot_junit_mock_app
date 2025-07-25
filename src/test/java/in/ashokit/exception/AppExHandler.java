package in.ashokit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExHandler {

	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<String> handleEx(RuntimeException e) {

		// logic

		return new ResponseEntity<>("Exception Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
