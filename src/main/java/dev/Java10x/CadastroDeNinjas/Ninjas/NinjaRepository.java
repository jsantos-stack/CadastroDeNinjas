package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

// O JPA é quem vai fazer esses shortcuts que fazemos no banco de dados para acessar as informações
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
