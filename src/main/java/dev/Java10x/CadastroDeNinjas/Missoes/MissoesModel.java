package dev.Java10x.CadastroDeNinjas.Missoes;
import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
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
    private long id;

    private String nomeDaMissao;

    @Column(unique = true) //Vai determinar que somente um email possa ser feito, não deixa repetir
    private String email;

    private String dificuldade;

//  Uma(one) missao para Muitos(many) ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
