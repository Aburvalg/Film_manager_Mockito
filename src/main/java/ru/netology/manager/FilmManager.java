package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmManager {
    private int limitForShow = 10;
    private FilmRepository repository;

    public FilmManager(int limitForShow) {
        this.limitForShow = limitForShow;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] showAll() {

//        int resultLength = films.length;
//        if (resultLength > limitForShow) {
//            resultLength = limitForShow;
//        } else {
//            resultLength = films.length;
        int resultLength = Math.min(limitForShow,films.length);// сокращая все предыдущее
        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length-i-1];
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
