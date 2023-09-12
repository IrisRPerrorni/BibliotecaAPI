package com.catalisa.biblioteca.repository;

import com.catalisa.biblioteca.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//O “@Repository” é uma versão especializada da anotação “@Component”.
// Indica que a classe é um repositório que contém armazenamento de dados e outras operações,
// como atualização, exclusão, pesquisa e recuperação de dados em objetos.
@Repository //chamando o repositorio
public interface LivrosRepository extends JpaRepository<LivrosModel,Long> {

}
