package br.com.midway.films.applications.models;

public enum Gender {
    MALE("male");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}