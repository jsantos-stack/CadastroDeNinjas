package dev.Java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // isso é um controlador
@RequestMapping // para colocar todas as rotas no mesmo lugar
public class NinjaController {
    @GetMapping("/boasvindas") //criando a rota
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }






}
