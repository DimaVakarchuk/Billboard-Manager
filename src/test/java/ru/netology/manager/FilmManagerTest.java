package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {
    private FilmManager manager = new FilmManager();

    private Film first = new Film(1, 1, "RushHour", "Comedy", "1999");
    private Film second = new Film(2, 2, "RushHour 2", "Comedy", "2001");
    private Film third = new Film(3, 3, "RushHour 3", "Comedy", "2007");
    private Film fourth = new Film(4, 4, "Avatar", "Action", "2009");
    private Film fifth = new Film(5, 5, "Avatar 2", "Action", "2022");
    private Film sixth = new Film(6, 6, "Avatar 3", "Action", "2023");
    private Film seventh = new Film(7, 7, "Avatar 4", "Action", "2024");
    private Film eighth = new Film(8, 8, "Jumanji", "Comedy", "1996");
    private Film ninth = new Film(9, 9, "Jumanji 2", "Comedy", "2017");
    private Film tenth = new Film(10, 10, "Transformers", "Action", "2007");
    private Film eleventh = new Film(11, 11, "Transformers 2", "Action", "2009");
    private Film twelveth = new Film(12, 12, "Transformers 3", "Action", "2011");

    @BeforeEach
    void addFilm() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
    }

    @Test
    public void getLastFilms() {
        FilmManager manager = new FilmManager(4);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(third);
        manager.addFilm(seventh);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{seventh, third, fifth, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastTenFilms() {
        FilmManager manager = new FilmManager(10);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getMoreThanTenFilms() {
        FilmManager manager = new FilmManager(12);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastZeroFilms() {
        FilmManager manager = new FilmManager(0);
        manager.addFilm(ninth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void get5Films() {
        FilmManager manager = new FilmManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void get0Films() {
        FilmManager manager = new FilmManager(0);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }
}