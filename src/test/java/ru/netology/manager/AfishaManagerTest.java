package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager = new AfishaManager(repository);
    Film first = new Film(1, 1, "RushHour", "Comedy", "1999");
    Film second = new Film(2, 2, "RushHour 2", "Comedy", "2001");
    Film third = new Film(3, 3, "RushHour 3", "Comedy", "2007");
    Film fourth = new Film(4, 4, "Avatar", "Action", "2009");
    Film fifth = new Film(5, 5, "Avatar 2", "Action", "2022");
    Film sixth = new Film(6, 6, "Avatar 3", "Action", "2023");
    Film seventh = new Film(7, 7, "Avatar 4", "Action", "2024");
    Film eighth = new Film(8, 8, "Jumanji", "Comedy", "1996");
    Film ninth = new Film(9, 9, "Jumanji 2", "Comedy", "2017");
    Film tenth = new Film(10, 10, "Transformers", "Action", "2007");
    Film eleventh = new Film(11, 11, "Transformers 2", "Action", "2009");
    Film twelveth = new Film(12, 12, "Transformers 3", "Action", "2011");
    Film thirteen = new Film(13, 13, "Transformers 4", "Action", "2015");
    Film fourteeth = new Film(14, 14, "Transformers 5", "Action", "2017");
    Film fifteenth = new Film(15, 15, "Judge", "History", "2015");

    @Test
    public void SaveVideo() {
        Film fifteenth = new Film(15, 15, "Judge", "History", "2015");
        Film[] returned;
        returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteen, fourteeth, fifteenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fifteenth);

        manager.addFilm(fifteenth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{fifteenth, fourteeth, thirteen, twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getlessThan15Video() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getDontDisplayVideo() {
        Film[] returned = new Film[]{first};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 0);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getMoreThan10Video() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteen, fourteeth, fifteenth};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,15);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{fifteenth, fourteeth, thirteen, twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void get7LastVideo() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,7);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

}
