package com.JKalango.webapi; 

import org.springframework.web.bind.annotation.RestController;

import com.JKalango.webapi.jogadores.DadosCadastroJogador;
import com.JKalango.webapi.jogadores.IJogadorRepository;
import com.JKalango.webapi.jogadores.Jogador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
      @Autowired
      private IJogadorRepository repository;

    @PostMapping
    @Transactional
    public void  cadastrar(@RequestBody @Valid DadosCadastroJogador dados){
        repository.save(new Jogador(dados));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public java.util.Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        java.util.Map<String, String> errors = new java.util.HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}