package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfishaRepositoryTest {
    private AfishaRepository repository;
    private AfishaManager manager = new AfishaManager();
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
    private Film thirteen = new Film(13, 13, "Transformers 4", "Action", "2015");
    private Film fourteeth = new Film(14, 14, "Transformers 5", "Action", "2017");
    private Film fifteenth = new Film(15, 15, "Judge", "History", "2015");

    @BeforeEach
    void setUp() {
        repository = new AfishaRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
        repository.save(twelveth);
        repository.save(thirteen);
        repository.save(fourteeth);
        repository.save(fifteenth);
    }

    @Test
    void save() {
        Film eleventh = new Film(15, 15, "Judge", "History", "2015");
        repository.save(fifteenth);
        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteen, fourteeth, fifteenth};
        assertArrayEquals(expected, actual);
    }


    @Test
    void findAll() {

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteen, fourteeth, fifteenth};
        assertArrayEquals(expected, actual);
    }


    @Test
    void removeById() {
        repository.removeById(25);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteen, fourteeth, fifteenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Film actual = repository.findById(15);
        assertEquals(fifteenth, actual);
    }


    @Test
    void removeAll() {
        repository.removeAll();

        Film[] actual = repository.findAll();
        Film[] expected = new Film[0];
        assertArrayEquals(expected, actual);
    }
}
