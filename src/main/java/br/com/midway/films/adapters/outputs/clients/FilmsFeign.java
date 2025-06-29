package br.com.midway.films.adapters.outputs.clients;

import br.com.midway.films.adapters.outputs.clients.response.FilmResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "filmsClient", url = "https://swapi.py4e.com/api/films")
public interface FilmsFeign {

    @GetMapping("/")
    FilmResponse getAllFilms();
}
