package dev.Java10x.CadastroDeNinjas.Ninjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDto {
/*
DTO = Data Transfer Object.
É um objeto criado especificamente para transportar dados entre camadas, principalmente entre a API e sua aplicação.
 */

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String ingUrl;
    private MissoesModel missoes;
    private String rank;
}
