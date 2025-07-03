package com.JKalango.webapi.jogadores; 

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroJogador(
                                    @NotNull(message = "O nome é obrigatório")
                                    String nome,
                                    
                                    @NotNull(message = "O nickName é obrigatório")
                                    @Pattern(regexp = ".*java.*", message = "O nickname deve conter 'java'")
                                    String nickName,
                                    
                                    @NotNull(message = "O email é obrigatório")
                                    String email,
                                    
                                    @NotNull(message = "A senha é obrigatória")
                                    String senha,
                                    
                                    @NotNull(message = "O telefone é obrigatório")
                                    String telefone) {
      

}