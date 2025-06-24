package com.JKalango.webapi;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Alo")
//requisição e resposta = Request e Response
//controller é como uma conversa com o serviudor = request e response

public class AloController {
      @GetMapping
      public String aloMundo (){
            return "Alo mundo - JKalango";
      }

}
