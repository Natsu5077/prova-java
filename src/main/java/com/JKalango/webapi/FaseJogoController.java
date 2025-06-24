package com.JKalango.webapi;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/fases")
public class FaseJogoController {
      @GetMapping
      public int mostrarQTddeFases(){
            return 7;
      }
}
