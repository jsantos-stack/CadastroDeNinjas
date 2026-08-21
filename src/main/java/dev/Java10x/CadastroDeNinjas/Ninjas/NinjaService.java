package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    //Serializar é fazer com que as funções feitas no banco de dados possam ser traduzidos pela JPA

    private final  NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaDto> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar todos os meus ninjas por ID
    public NinjaDto listasNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Criar um ninja
    public NinjaDto criarNinja(NinjaDto ninjaDto) {
        NinjaModel ninja = ninjaMapper.map(ninjaDto);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar o ninja - Tem que ser um metodo VOID
    public void deletarNinjasPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaDto atualizarNinja(Long id, NinjaDto ninjaDto) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
    if (ninjaExistente.isPresent()){
        NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDto);
        ninjaAtualizado.setId(id);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
        return ninjaMapper.map(ninjaSalvo);
    }
        return null;
    }
}
