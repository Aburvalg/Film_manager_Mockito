package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmManager {
    private int limitForShow;
    private FilmRepository repo;

    public FilmManager(FilmRepository repo) {
        this.repo = repo;
        this.limitForShow = 10;
    }

    public FilmManager(int limitForShow) {
        this.repo = repo;
        this.limitForShow = limitForShow;
    }

    public void add(Film film) {
        repo.save(film);
    }

    public Film[] showAllStartLast() {
        var filmsFromRepo = repo.showAll();
        int resultLength = Math.min(limitForShow,filmsFromRepo.size());// сокращая все предыдущее
        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = filmsFromRepo.get(filmsFromRepo.size()-i-1);
        }
        return result;
    }

    public Film[] findWithSort(Comparator<Film> comparator) {
        var result = repo.showAll();
        result.sort(comparator);
        return result.toArray(new Film[0]); // реализуется обратная совместимость листа в массив
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    private Film [] findBy (Predicate<Film>filter){ //общая логика поиска вынесена в отдельный приватный метод
        var filmsFromRepo = repo.showAll();
        var result = new ArrayList<Film>();
        for(Film film:filmsFromRepo){
            if(filter.test(film)){
                result.add(film);
            }
        }
        return result.toArray(new Film[0]);
    }

    public Film findById (int id){
        Film[] films = findBy(film -> film.getId()==id);
        if(films.length==0) {
            throw new RuntimeException("Film with id:" + id + "not found");
        }
        if(films.length>1) {
            throw new RuntimeException("Film with id:" + id + "non unique");
        }
        return films[0];
    }

    public Film[] findByNameFilm (String text){
        return findBy(film-> film.getNameFilm().equalsIgnoreCase(text));
    }

}
