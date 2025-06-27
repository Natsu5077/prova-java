package com.JKalango.webapi.jogadores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="jogador")
@Getter
@NoArgsConstructor //JPA exige um construtor vázio
@AllArgsConstructor //contrutor com todas as anotações(campos)
@EqualsAndHashCode(of = "id") //comparar objetos e colections 
@Entity(name="jogador")
public class Jogador {
      @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
      private Long id;
      private  String nome;
      private  String nickName;
      private String email;
      private String senha;
      private String telefone;
      public Jogador(DadosCadastroJogador dados){
            this.nome =dados.nome();
            this.nickName = dados.nickName();
            this.email = dados.email();
            this.senha = dados.senha();
            this.telefone = dados.telefone();
      }
}
