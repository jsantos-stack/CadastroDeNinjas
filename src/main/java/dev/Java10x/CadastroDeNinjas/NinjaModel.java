package dev.Java10x.CadastroDeNinjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity //Criar com as informações tabelas, como de nome, email..
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome, email;

    private int idade;

//    Somente para um unico elemento. Ex: Um ninja só pode ter uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  //Foreing Key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
