package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Film {
        private int id;
        private int productId;
        private String filmName;
        private String descriptionAndgenre;
        private String releaseYear;

    }

