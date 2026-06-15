package com.SpringBoot.AprenderSpring.service;
// Lógica de negócios

import com.SpringBoot.AprenderSpring.domain.Anime;
import com.SpringBoot.AprenderSpring.mapper.AnimeMapper;
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

        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

        public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        animeRepository.save(anime);
        //save() Ele serve tanto para INSERT quanto UPDATE, se não tiver id INSERT, se tiver UPDATE
    }
}
