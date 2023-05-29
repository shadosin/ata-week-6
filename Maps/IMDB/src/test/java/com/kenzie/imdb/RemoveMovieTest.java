package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveMovieTest extends ImdbTest {

    @Test
    public void removeMovie_notInImdb_returnsFalse() {
        // GIVEN - unreleased movie

        // WHEN
        boolean result = imdb.removeMovie(SHAWSHANK);

        // THEN
        assertFalse(result, "Expected a false response when removing an unreleased movie.");
    }

    @Test
    public void removeMovie_inImdb_returnsTrue() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        imdb.releaseMovie(SHAWSHANK, cast);

        // WHEN
        boolean result = imdb.removeMovie(SHAWSHANK_COPY);

        // THEN
        assertTrue(result, "Expected a true response when removing a released movie.");

    }

    @Test
    public void removeMovie_inImdb_movieRemoved() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        imdb.releaseMovie(SHAWSHANK, cast);

        // WHEN
        imdb.removeMovie(SHAWSHANK);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> imdb.getActorsInMovie(SHAWSHANK_COPY), "Expected an exception" +
                "when getting cast for a removed movie.");
    }
}
