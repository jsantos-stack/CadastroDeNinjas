package dev.Java10x.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;

public class MissoesService {

    //Serializar é fazer com que as funções feitas no banco de dados possam ser traduzidos pela JPA

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todos os meus ninjas
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public MissoesModel listarMissoesPorId(long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // Criar um ninja
    public MissoesModel criarMissao(MissoesModel ninja) {
        return missoesRepository.save(ninja);
    }

    // Deletar o ninja - Tem que ser um metodo VOID
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
