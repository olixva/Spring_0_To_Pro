package com.curso.spring.service;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.dao.FilmDao;
import com.curso.spring.model.Film;

@Service
public class FilmQueryServiceImpl implements FilmQueryService {

    @Autowired
    private FilmDao dao;

    private Predicate<Film> predicate;

    public void init() {
        predicate = null;
    }

    @Override
    public Collection<Film> exec() {
        return dao.findAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public FilmQueryService anyGenre(String... genre) {

        Predicate<Film> pAnyGenre = (film) -> {
            for (String g : genre) {
                if (film.getGenres().contains(g)) {
                    return true;
                }
            }
            return false;
        };

        if (predicate == null) {
            predicate = pAnyGenre;
        } else {
            predicate = predicate.and(pAnyGenre);
        }
        return this;
    }

    @Override
    public FilmQueryService allGenres(String... genres) {

        Predicate<Film> pAllGenres = (film) -> {
            for (String g : genres) {
                if (!film.getGenres().contains(g)) {
                    return false;
                }
            }
            return true;
        };

        if (predicate == null) {
            predicate = pAllGenres;
        } else {
            predicate = predicate.and(pAllGenres);
        }
        return this;
    }

    @Override
    public FilmQueryService year(String year) {

        Predicate<Film> pYear = (film) -> {
            return film.getYear().equals(year);
        };

        if (predicate == null) {
            predicate = pYear;
        } else {
            predicate = predicate.and(pYear);
        }
        return this;
    }

    @Override
    public FilmQueryService betweenYears(String from, String to) {

        Predicate<Film> pBetweenYears = (film) -> {
            return film.getYear().compareTo(from) >= 0 && film.getYear().compareTo(to) <= 0;
        };

        if (predicate == null) {
            predicate = pBetweenYears;
        } else {
            predicate = predicate.and(pBetweenYears);
        }
        return this;
    }

    @Override
    public FilmQueryService titleContains(String title) {

        Predicate<Film> pTittleContains = (film) -> {
            return film.getTitle().toLowerCase().contains(title.toLowerCase());
        };

        if (predicate == null) {
            predicate = pTittleContains;
        } else {
            predicate = predicate.and(pTittleContains);
        }
        return this;
    }

}
