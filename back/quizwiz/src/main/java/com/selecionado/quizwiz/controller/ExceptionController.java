package com.selecionado.quizwiz.controller;


import com.selecionado.quizwiz.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {


    /**
     * Captura y devuleve el mensaje de excepcion argumento de metodo no valido en una respuesta http
     * @param ex excepcion de argumento de metodo no valido
     * @return respuesta http con mensaje de excepcion
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validException(MethodArgumentNotValidException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errorDetails.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Captura y devuelve mensaje de excepcion de id, rol o correo no encontrado en una respuesta http
     * @param ex excepcion
     * @return respuesta http con mensaeje de excepcion
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({FormNotFoundException.class, UserIDNotFoundException.class, QuestionNotFoundExcepion.class})
    public ResponseEntity<ErrorMessage> notFoundExceptions(Exception ex) {

        var errorDetails = new ErrorMessage();
        errorDetails.setStatuscode(HttpStatus.NOT_FOUND.value() + " NOT_FOUND");
        errorDetails.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    //devuelve excepciones de datos ya existentes y excepciones generales

    /**
     * Captura los mensajes de excepcion de solicitud incorrecta y los devuelve en una respuesta http
     * @param ex mensaje de excecion
     * @return respuesta http con mensaje
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ExistsEmailException.class, ConfirmPasswordException.class, Exception.class})
    public ResponseEntity<ErrorMessage> badRequestExceptions(Exception ex) {

        var errorDetails = new ErrorMessage();
        errorDetails.setStatuscode(HttpStatus.BAD_REQUEST.value() + " BAD_REQUEST");
        errorDetails.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Captura y devuelve excepciones de credenciales mal ingresadas en el login
     * @return respuesta http con mensaje de excepcion de credenciales incorrectas
     */
    //
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMessage> badCredentialsExceptions() {

        var errorDetails = new ErrorMessage();
        errorDetails.setStatuscode(HttpStatus.BAD_REQUEST.value() + " BAD_REQUEST");
        errorDetails.setMessage("usuario o contraseña incorrecta. Revise los datos ingresados");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Captura y devuelve excepciones de formatos mal ingresados
     * @return respuesta http con mensaje de formato de solicitud incorrecto
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorMessage> badRequestFormatExceptions() {

        var errorDetails = new ErrorMessage();
        errorDetails.setStatuscode(HttpStatus.BAD_REQUEST.value() + " BAD_REQUEST");
        errorDetails.setMessage("El tipo de formato ingresado es incorrecto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Captura y devuelve excepciones de tipeo
     * @return respuesta http con mensaje de error de tipeo
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> typingErrorExceptions() {

        var errorDetails = new ErrorMessage();
        errorDetails.setStatuscode(HttpStatus.NOT_FOUND.value() + " NOT_FOUND");
        errorDetails.setMessage("Error de tipeo: Revise los datos ingresados.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }


}
