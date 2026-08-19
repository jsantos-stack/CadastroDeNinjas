package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
//    O Mapper é quem faz a conversão entre os objetos.

public NinjaModel map(NinjaDto ninjaDto) {
//    Pegando do model e botando no DTO
    NinjaModel ninjaModel = new NinjaModel();
    ninjaModel.setId(ninjaDto.getId());
    ninjaModel.setId(ninjaDto.getId());
    ninjaModel.setEmail(ninjaDto.getEmail());
    ninjaModel.setNome(ninjaDto.getNome());
    ninjaModel.setMissoes(ninjaDto.getMissoes());
    ninjaModel.setRank(ninjaDto.getRank());
    ninjaModel.setIngUrl(ninjaDto.getIngUrl());

    return ninjaModel;
}

    public NinjaDto map(NinjaModel ninjaModel) {

        NinjaDto ninjaDto = new NinjaDto();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setEmail(ninjaModel.getEmail());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setMissoes(ninjaModel.getMissoes());
        ninjaDto.setRank(ninjaModel.getRank());
        ninjaDto.setIngUrl(ninjaModel.getIngUrl());

        return ninjaDto;
}





}
