package undersociety.controller;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoSuchElementExceptionControllerAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public void handleNoTFound(HttpServletResponse response) throws IOException {
		response.sendRedirect("/error");
	}
}
