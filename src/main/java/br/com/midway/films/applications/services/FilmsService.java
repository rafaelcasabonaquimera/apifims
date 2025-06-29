package br.com.midway.films.applications.services;

import br.com.midway.films.applications.models.Film;
import br.com.midway.films.applications.ports.inputs.FilmsPort;
import br.com.midway.films.applications.ports.outputs.FilmsPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsService implements FilmsPort {
    private FilmsPersistencePort filmsPersistencePort;

    public FilmsService(FilmsPersistencePort filmsPersistencePort) {
        this.filmsPersistencePort = filmsPersistencePort;
    }

    @Override
    public List<Film> getFilms() {
        return filmsPersistencePort.getFilms();
    }

    @Override
    public Film postFilm(final int episodeId, final String nameUpdated) {
        return filmsPersistencePort.postFilm(episodeId, nameUpdated);

    }

    @Override
    public Film getFilm(final int episodeId) {
        return filmsPersistencePort.getFilm(episodeId);
    }

    @Override
    public Film postFilmDetail(int episodeId, String detail) {
        return filmsPersistencePort.updateFilmDetail(episodeId, detail);
    }
}
