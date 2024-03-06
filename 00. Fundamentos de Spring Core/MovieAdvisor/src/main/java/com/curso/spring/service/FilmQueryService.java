package com.curso.spring.service;

import java.util.Collection;

import com.curso.spring.model.Film;

public interface FilmQueryService {

    public Collection<Film> exec();

    public FilmQueryService anyGenre(String... genre);

    public FilmQueryService allGenres(String... genres);

    public FilmQueryService year(String year);

    public FilmQueryService betweenYears(String from, String to);

    public FilmQueryService titleContains(String title);

}
