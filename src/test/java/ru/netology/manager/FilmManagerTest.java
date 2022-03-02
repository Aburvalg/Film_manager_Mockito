package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    private FilmManager manager = new FilmManager(new FilmRepository());

    private Film first = new Film(1, "eger", "action");
    private Film second = new Film(2, "verr", "drama");
    private Film third = new Film(3, "dfer", "comedy");
    private Film fourth = new Film(4, "eger", "action");
    private Film fifth = new Film(5, "ve", "drama");
    private Film sixth = new Film(6, "dfer", "comedy");
    private Film seventh = new Film(7, "eger", "action");
    private Film eight = new Film(8, "verr", "drama");
    private Film ninth = new Film(9, "dfer", "comedy");
    private Film tenth = new Film(10, "eger", "action");
    private Film eleventh = new Film(11, "verr", "drama");
    private Film twelfth = new Film(12, "dfer", "comedy");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    public  void shouldSort(){
        manager.removeById(2);
        manager.removeById(4);
        manager.removeById(6);
        manager.removeById(8);
        manager.removeById(9);
        manager.removeById(10);
        manager.removeById(12);
        Film[] actual = manager.findWithSort((a,b)->(a.getId()-b.getId())); // на ввод подаются две сущности и сравниваются, их названия без разницы
        assertArrayEquals(new Film[]{first,third,fifth,seventh,eleventh},actual);
    }

    @Test
    public void shouldFindById(){
        assertEquals(fifth, manager.findById(5));
    }

    @Test
    public void shouldFindByNameFilm(){
        assertArrayEquals(new Film[]{fifth}, manager.findByNameFilm("ve"));
    }

    @Test
    public void shouldShowAllFilms() {
        Film[] actual = manager.showAllStartLast();
        Film[] expected = {twelfth, eleventh, tenth, ninth, eight, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllFullFilmsWithLimit() {
        FilmManager manager = new FilmManager(5,new FilmRepository());
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        Film[] actual = manager.showAllStartLast();
        Film[] expected = {twelfth, eleventh, tenth, ninth, eight};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllOneFilm() {
        Film first = new Film(1, "eger", "action");

        FilmManager manager = new FilmManager(new FilmRepository());
        manager.add(first);

        Film[] actual = manager.showAllStartLast();
        Film[] expected = {first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllNoFilm() {

        FilmManager manager = new FilmManager(new FilmRepository());

        Film[] actual = manager.showAllStartLast();
        Film[] expected = {};
        assertArrayEquals(expected, actual);

    }

}
