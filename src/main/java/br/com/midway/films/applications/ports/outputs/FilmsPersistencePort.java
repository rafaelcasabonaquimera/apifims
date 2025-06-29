package br.com.midway.films.applications.ports.outputs;

import br.com.midway.films.applications.models.Film;

import java.util.List;

public interface FilmsPersistencePort {
    public List<Film> getFilms();
    public Film postFilm(final int episodId, final String nameUpdated);
    public Film getFilm(final int episodeId);
    public Film updateFilmDetail(final int episodeId, final String detailUpdated);
}
