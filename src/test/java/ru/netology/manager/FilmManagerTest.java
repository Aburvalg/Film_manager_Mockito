package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    @Test
    public void shouldShowAllFilms() {
        Film first = new Film(1, "eger", "action");
        Film second = new Film(2, "verr", "drama");
        Film third = new Film(3, "dfer", "comedy");
        Film fourth = new Film(4, "eger", "action");
        Film fifth = new Film(5, "verr", "drama");
        Film sixth = new Film(6, "dfer", "comedy");
        Film seventh = new Film(7, "eger", "action");
        Film eight = new Film(8, "verr", "drama");
        Film ninth = new Film(9, "dfer", "comedy");
        Film tenth = new Film(10, "eger", "action");
        Film eleventh = new Film(11, "verr", "drama");
        Film twelfth = new Film(12, "dfer", "comedy");

        FilmManager manager = new FilmManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eight);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        manager.save(twelfth);

        Film[] actual = manager.showAll();
        Film[] expected = {twelfth, eleventh, tenth, ninth, eight, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllFullFilmsWithLimit() {
        Film first = new Film(1, "eger", "action");
        Film second = new Film(2, "verr", "drama");
        Film third = new Film(3, "dfer", "comedy");
        Film fourth = new Film(4, "eger", "action");
        Film fifth = new Film(5, "verr", "drama");
        Film sixth = new Film(6, "dfer", "comedy");
        Film seventh = new Film(7, "eger", "action");
        Film eight = new Film(8, "verr", "drama");
        Film ninth = new Film(9, "dfer", "comedy");
        Film tenth = new Film(10, "eger", "action");
        Film eleventh = new Film(11, "verr", "drama");
        Film twelfth = new Film(12, "dfer", "comedy");

        FilmManager manager = new FilmManager(5);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eight);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        manager.save(twelfth);

        Film[] actual = manager.showAll();
        Film[] expected = {twelfth, eleventh, tenth, ninth, eight};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllOneFilm() {
        Film first = new Film(1, "eger", "action");

        FilmManager manager = new FilmManager();
        manager.save(first);

        Film[] actual = manager.showAll();
        Film[] expected = {first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowAllNoFilm() {

        FilmManager manager = new FilmManager();

        Film[] actual = manager.showAll();
        Film[] expected = {};
        assertArrayEquals(expected, actual);

    }

}
