package dev.Java10x.CadastroDeNinjas.Ninjas;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // isso é um controlador
@RequestMapping // para colocar todas as rotas no mesmo lugar
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
    public String criarNinja() {
        return "Ninja criado";
    }


    //Mostrar todos os ninjs (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrar ninja por Id";
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterarId")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por id";
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }



}
