package com.SpringBoot.AprenderSpring.mapper;

import com.SpringBoot.AprenderSpring.domain.Anime;
import com.SpringBoot.AprenderSpring.requests.AnimePostRequestBody;
import com.SpringBoot.AprenderSpring.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")  // Possibilita a injeção de dependência
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    // Vão converter auto todos os atributos no Put para o Anime
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePostRequestBody);
}
