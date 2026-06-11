package com.SpringBoot.AprenderSpring.controller;
// Classe onde ficam os end points

import com.SpringBoot.AprenderSpring.domain.Anime;
import com.SpringBoot.AprenderSpring.service.AnimeService;
import com.SpringBoot.AprenderSpring.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DataUtil dataUtil;
    private final AnimeService animeService;

    //http://localhost:8080/anime/list
    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return  ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findBtyd(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    @ResponseStatus()
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
