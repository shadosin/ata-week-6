package com.kenzie.imdb;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class ImdbTest {

    protected static final Movie SHAWSHANK = new Movie("The Shawshank Redemption", "Frank Darabont",
            LocalDate.of(1994, 10, 14));
    protected static final Movie SHAWSHANK_COPY = new Movie("The Shawshank Redemption", "Frank Darabont",
            LocalDate.of(1994, 10, 14));
    protected static final Movie BUCKET_LIST = new Movie("The Bucket List", "Rob Reiner",
            LocalDate.of(2008, 1, 11));
    protected static final Movie GONE_BABY_GONE = new Movie("Gone Baby Gone", "Ben Affleck",
            LocalDate.of(2007, 10, 19));

    protected static final Actor MORGAN_FREEMAN = new Actor("Morgan Freeman",
            LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
    protected static final Actor MORGAN_COPY = new Actor("Morgan Freeman",
            LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
    protected static final Actor TIM_ROBBINS = new Actor("Tim Robbins",
            LocalDate.of(1958, 10, 16), "West Covina, California");
    protected static final Actor TIM_COPY = new Actor("Tim Robbins",
            LocalDate.of(1958, 10, 16), "West Covina, California");
    protected static final Actor WILLIAM_SADLER = new Actor("William Sadler",
            LocalDate.of(1950, 4, 13), "Buffalo, New York");
    protected static final Actor CASEY_AFFLECK = new Actor("Casey Affleck",
            LocalDate.of(1975, 8, 12), "Falmouth, Massachusetts");

    protected Imdb imdb;

    @BeforeEach
    public void setup() {
        imdb = new Imdb();
    }
}
