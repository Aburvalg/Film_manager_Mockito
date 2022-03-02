package ru.netology.repository;

import ru.netology.domain.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository {
    private List<Film> films = new ArrayList();

    public void save(Film newFilm) {
       films.add(newFilm);
    }

    public List<Film> showAll() {
        return films;
    }

    public void removeById(int id) {
        films.removeIf(el->el.getId()==id);//используется Predicate,удалить, если id элемента равно id заданному
    }


}
