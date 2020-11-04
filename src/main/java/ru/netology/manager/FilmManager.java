package ru.netology.manager;

import ru.netology.domain.Film;

public class FilmManager {
    private Film[] items = new Film[0];
    private int countFilms = 10;

    public FilmManager() {
    }

    public FilmManager(int countFilms) {
        this.countFilms = countFilms;
    }

    public void addFilm(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] getFilms() {
        int length = Math.min(items.length, countFilms);

        Film[] result = new Film[length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}