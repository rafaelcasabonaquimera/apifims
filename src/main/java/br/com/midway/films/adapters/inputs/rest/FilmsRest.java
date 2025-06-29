package br.com.midway.films.adapters.inputs.rest;

import br.com.midway.films.adapters.inputs.rest.request.RequestFilm;
import br.com.midway.films.adapters.inputs.rest.request.RequestFilmDetailRequest;
import br.com.midway.films.applications.models.Film;
import br.com.midway.films.applications.ports.inputs.FilmsPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmsRest {

    private FilmsPort filmsPort;

    public FilmsRest(FilmsPort filmsPort) {
        this.filmsPort = filmsPort;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getFilms() {
        return ResponseEntity.ok(filmsPort.getFilms());
    }

    @PostMapping("/{episodeId}")
    public ResponseEntity<Film> postFilm(@PathVariable int episodeId, @RequestBody RequestFilm request) {
        return Optional.ofNullable(filmsPort.postFilm(episodeId, request.getNameUpdated()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ofNullable(null));
    }

    @GetMapping("/{episodeId}")
    public ResponseEntity<Film> getFilm(@PathVariable int episodeId) {
        return Optional.ofNullable(filmsPort.getFilm(episodeId))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @PostMapping("/{episodeId}/detail")
    public ResponseEntity<Film> postFilmDetail(@PathVariable int episodeId, @RequestBody RequestFilmDetailRequest request) {
        return Optional.ofNullable(filmsPort.postFilmDetail(episodeId, request.getDetail()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ofNullable(null));
    }

}
