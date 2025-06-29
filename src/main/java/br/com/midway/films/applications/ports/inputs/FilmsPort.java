package br.com.midway.films.applications.ports.inputs;

import br.com.midway.films.applications.models.Film;

import java.util.List;

public interface FilmsPort {
    public List<Film> getFilms();
    public Film postFilm(final int episodeId, final String nameUpdated);
    public Film getFilm(final int episodeId);
    public Film postFilmDetail(final int episodeId, final String detailUpdated);
}
