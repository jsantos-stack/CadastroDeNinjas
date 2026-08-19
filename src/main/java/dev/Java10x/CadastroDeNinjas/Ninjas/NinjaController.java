package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // isso é um controlador
@RequestMapping ("/ninja")// para colocar todas as rotas no mesmo lugar
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas") //criando a rota
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //    C.R.U.D
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDto criarNinja(@RequestBody NinjaDto ninja) {// serialização contraria
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjs (READ)
    @GetMapping("/listar")
    public List<NinjaDto> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // O id ao lado de listar é para selecionar qual o id vc quer escolher
    // @pathvariable torna o parametro para o mapeamento do caminho
    // Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDto listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listasNinjasPorID(id);
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDto alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDto ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id ) { //pathvariable é para que seja usado na url
    ninjaService.deletarNinjasPorId(id);
    }
}
