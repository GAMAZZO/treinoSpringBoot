package com.SpringBoot.AprenderSpring.repository;
// Conexão com o banco de dados

import com.SpringBoot.AprenderSpring.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
