package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmManager {
    private Film[] films = new Film[0];
    //private FilmRepository repository;
    private int limitForShow = 10;

//    public FilmManager(FilmRepository repository) {
//        this.repository = repository;
//    }

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] showAll() {

        int resultLength = films.length;
        if (resultLength > limitForShow) {
            resultLength = limitForShow;
        } else {
            resultLength = films.length;
        }

        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] showAll(int limitForShow) {

        int resultLength = films.length;
        if (resultLength > limitForShow) {
            resultLength = limitForShow;
        } else {
            resultLength = films.length;
        }

        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
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
