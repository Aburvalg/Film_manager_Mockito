package ru.netology.repository;

import ru.netology.domain.Film;

public class FilmRepository {
    private Film[] films = new Film[0];

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] showAll() {
        return films;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }


}
