package com.danilo.workshopmongo.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.danilo.workshopmongo.service.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//Interceptar as exceções que acontecerem para que esse objeto possa executar um possivel tratamento 
@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Para que seja capar de interceptar a requisição que deu exceção 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value() ,error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
//	@ExceptionHandler(DataBaseException.class)
//	public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request){
//		String error = "Database error";
//		HttpStatus status = HttpStatus.BAD_REQUEST; 
//		StandardError err = new StandardError(Instant.now(), status.value() , error , e.getMessage(), request.getRequestURI());
//		return ResponseEntity.status(status).body(err);
//	}

}
