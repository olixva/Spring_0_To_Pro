package com.curso.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.spring.config.AppConfig;
import com.curso.spring.model.Film;

@Repository
public class FilmDaoImplMemory implements FilmDao {

    private List<Film> peliculas = new ArrayList<>();

    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    public void init() {
        this.peliculas = UtilFilmFileReader.readFile(appConfig.getFile(), appConfig.getSeparator(),
                appConfig.getListSeparator());
    }

    @Override
    public Film getmById(long id) {

        for (Film film : peliculas) {
            if (film.getId() == id) {
                return film;
            }
        }

        return null;
    }

    @Override
    public Collection<Film> findAll() {
        return peliculas;
    }

    @Override
    public void insert(Film film) {
        peliculas.add(film);
    }

    @Override
    public void edit(Film film) {
        int index = getIndexOf(film.getId());
        if (index != -1) {
            peliculas.set(index, film);
        }
    }

    @Override
    public void delete(long id) {
        int index = getIndexOf(id);
        if (index != -1) {
            peliculas.remove(index);
        }
    }

    private int getIndexOf(long id) {

        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
