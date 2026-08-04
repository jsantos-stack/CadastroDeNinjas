package dev.Java10x.CadastroDeNinjas.Ninjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Criar com as informações tabelas, como de nome, email..
@Table(name = "tb_cadastro") //Para setar o nome pelo qual a classe vai ser chamada
@AllArgsConstructor //Faz com que construtores com todos os argumentos sejam feitos automaticamente
@NoArgsConstructor //Faz um construtor vazio. Economizando muitas linhas
@Data //Faz os getters e setters tbm automaticamente, mesmo quando são adicionados depois
public class NinjaModel {

    @Id //Para o java determinar um id de uma tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Somente para dar nome a coluna feita
    private Long id;

    @Column(name = "nome")
    private String nome, email;

@Column(name = "idade")
    private int idade;

    @Column(name = "ing_url")
    private String ingUrl;

//    Somente para um unico elemento. Ex: Um ninja só pode ter uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  //Foreing Key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}
