package com.SpringBoot.AprenderSpring.service;
// Lógica de negócios

import com.SpringBoot.AprenderSpring.domain.Anime;
import com.SpringBoot.AprenderSpring.repository.AnimeRepository;
import com.SpringBoot.AprenderSpring.requests.AnimePostRequestBody;
import com.SpringBoot.AprenderSpring.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll(){
      return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
      return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {

        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());

        Anime anime = Anime.builder()
                .id(savedAnime.getId())     // (savedAnime)Pra ter certeza que o id é o que está no banco de dados e o resto do objeto vai ser atualizado
                .name(animePutRequestBody.getName())    //(savedAnime faz a mesma coisa que animePutRequestBody.getName())
                        .build();
        animeRepository.save(anime);
        //save() Ele serve tanto para INSERT quanto UPDATE, se não tiver id INSERT, se tiver UPDATE
    }
}
