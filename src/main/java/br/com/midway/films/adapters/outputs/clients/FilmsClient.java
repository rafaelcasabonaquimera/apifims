package br.com.midway.films.adapters.outputs.clients;

import br.com.midway.films.applications.models.Film;
import br.com.midway.films.applications.ports.outputs.FilmsPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmsClient implements FilmsPersistencePort {
    private final List<Film> films;

    public FilmsClient(FilmsFeign filmsFeign) {
        this.films = filmsFeign.getAllFilms().getResults();
    }

    @Override
    public List<Film> getFilms() {
        return films;
    }

    @Override
    public Film postFilm(final int episodeId, final String nameUpdated) {
        return films.stream()
                .filter(film -> film.getEpisodeId() == episodeId)
                .findFirst()
                .map(film -> {
                    film.setTitle(nameUpdated);
                    return film;
                })
                .orElse(null);
    }

    @Override
    public Film getFilm(final int episodeId) {
        return films.stream()
                .filter(film -> film.getEpisodeId() == episodeId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Film updateFilmDetail(int episodeId, String detailUpdated) {
        return films.stream()
                .filter(film -> film.getEpisodeId() == episodeId)
                .findFirst()
                .map(film -> {
                    film.getDescriptions().add(detailUpdated);
                    film.setVersion(film.getVersion() + 1);
                    return film;
                })
                .orElseThrow(() -> new IllegalArgumentException("Film not found with episodeId: " + episodeId));
    }
}
