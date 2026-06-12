package com.SpringBoot.AprenderSpring.repository;
// Conexão com o banco de dados

import com.SpringBoot.AprenderSpring.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    /*Cria para mim um repositório capaz de manipular objetos Anime cujo id é Long.
    Não precisa escrever métodos( findAll(), findById(), save(), delete()) pois já existem dentro do JpaRepository*/
}
