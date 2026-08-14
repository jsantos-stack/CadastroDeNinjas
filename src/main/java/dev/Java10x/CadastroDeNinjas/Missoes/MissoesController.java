package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController { @GetMapping("/boasvindasmissoes") //criando a rota
public String boasVindas() {
    return "Essa é a minha mensagem das missoes para tu";
}

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //    C.R.U.D
    // Adicionar Missao (CREATE)
    @PostMapping("/criarmissao")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel) {// serialização contraria
        return missoesService.criarMissao(missoesModel);
    }

    //Mostrar todos os ninjs (READ)
    @GetMapping("/listarmissao")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // O id ao lado de listar é para selecionar qual o id vc quer escolher
    // @pathvariable torna o parametro para o mapeamento do caminho
    // Mostrar Ninja por ID (READ)
    @GetMapping("/listarmissao/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable long id) {
        return missoesService.listarMissoesPorId(id);
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alteraridmissao")
    public String alterarMissaoPorId() {
        return "Alterar Missão por id";
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterarmissao/{id}")
    public MissoesModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizado) {
        return missoesService.atualizarMissao(id, missaoAtualizado);
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletarmissao/{id}")
    public void deletarMissaoPorId(@PathVariable Long id ) { //pathvariable é para que seja usado na url
        missoesService.deletarMissaoPorId(id);
    }
}
