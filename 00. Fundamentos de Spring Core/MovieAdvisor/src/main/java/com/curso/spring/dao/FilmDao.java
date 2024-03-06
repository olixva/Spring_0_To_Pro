package com.curso.spring.dao;

import java.util.Collection;

import com.curso.spring.model.Film;

public interface FilmDao {

    public Film getmById(long id);

    public Collection<Film> findAll();

    public void insert(Film film);

    public void edit(Film film);

    public void delete(long id);

}
