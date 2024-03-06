package com.curso.spring.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.curso.spring.model.Film;

public class UtilFilmFileReader {

    public static List<Film> readFile(final String path, final String separator, final String listSeparator) {
        List<Film> films = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);

                List<String> genresList = Arrays.asList(values[3].split(listSeparator));

                films.add(new Film(Long.parseLong(values[0]), values[1], values[2], genresList));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return films;
    }
}
