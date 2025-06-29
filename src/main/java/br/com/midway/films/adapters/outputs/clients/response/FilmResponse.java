package br.com.midway.films.adapters.outputs.clients.response;

import br.com.midway.films.applications.models.Film;

import java.util.List;

public class FilmResponse {
    private int count;
    private String next;
    private String previous;
    private List<Film> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}