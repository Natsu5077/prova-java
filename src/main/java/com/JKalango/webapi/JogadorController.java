package com.JKalango.webapi;
import org.springframework.web.bind.annotation.RestController;

import com.JKalango.webapi.jogadores.DadosCadastroJogador;
import com.JKalango.webapi.jogadores.IJogadorRepository;
import com.JKalango.webapi.jogadores.Jogador;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
      @Autowired //onjeção de dependencia
      private IJogadorRepository repository;
//criar atrbuto



@PostMapping
@Transactional
public void  cadastrar(@RequestBody DadosCadastroJogador dados){
      //System.out.println(dados);.
      //Jogador j = new Jogador(dados); //construtor normal 
      repository.save(new Jogador(dados)); //injetado mesma coisa de criar o objeto com construtor 
}
}
