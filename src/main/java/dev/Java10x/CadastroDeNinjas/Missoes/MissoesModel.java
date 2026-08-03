package dev.Java10x.CadastroDeNinjas.Missoes;
import dev.Java10x.CadastroDeNinjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private String dificuldade;

//  Uma(one) missao para Muitos(many) ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
