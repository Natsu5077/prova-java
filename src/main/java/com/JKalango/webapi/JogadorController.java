package com.JKalango.webapi;
import org.springframework.web.bind.annotation.RestController;

import com.JKalango.webapi.jogadores.DadosCadastroJogador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
@PostMapping
public void  cadastrar(@RequestBody DadosCadastroJogador dados){
      System.out.println(dados);
}
}
