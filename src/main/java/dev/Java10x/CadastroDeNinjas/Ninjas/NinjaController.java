package dev.Java10x.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // isso é um controlador
@RequestMapping ("/ninja")// para colocar todas as rotas no mesmo lugar
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas") //criando a rota
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //    C.R.U.D
    // Adicionar ninja (CREATE)
    @PostMapping("/criar") // ResponseEntity vai dar a resposta a comandos errados, mas que são rodados de forma certa.
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDto ninja) {// serialização contraria
        NinjaDto novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID) " + novoNinja);
    }

    //Mostrar todos os ninjs (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDto>> listarNinjas() {
        List<NinjaDto> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // O id ao lado de listar é para selecionar qual o id vc quer escolher
    // @pathvariable torna o parametro para o mapeamento do caminho
    // Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {

        NinjaDto ninja = ninjaService.listasNinjasPorID(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " não encontrado");
        }
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDto ninjaAtualizado) {

        NinjaDto ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + "não encontrado");
        }
    }


    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) { //pathvariable é para que seja usado na url
        if (ninjaService.listasNinjasPorID(id) != null) {
            ninjaService.deletarNinjasPorId(id);
            return ResponseEntity.ok("Ninja com o id: " + id + " deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " não encontrado.");
        }
    }
}

