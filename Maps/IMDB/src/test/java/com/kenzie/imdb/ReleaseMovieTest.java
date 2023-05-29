package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReleaseMovieTest extends ImdbTest {

    @Test
    public void releaseMovie_notInImdb_movieAddedWithCast() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);

        // WHEN
        imdb.releaseMovie(SHAWSHANK, cast);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);
        assertEquals(cast, resultsCast, "Expected actors in movie cast to match what was released.");
    }

    @Test
    public void releaseMovie_dupesInCast_movieAddedWithCast() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        cast.add(MORGAN_COPY);

        // WHEN
        imdb.releaseMovie(SHAWSHANK, cast);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);
        assertEquals(2, resultsCast.size(), "Expected no duplicates actors in movie cast.");
    }

    @Test
    public void releaseMovie_inImdbNewCastMember_castUpdated() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        imdb.releaseMovie(SHAWSHANK, cast);

        cast.add(WILLIAM_SADLER);

        // WHEN
        imdb.releaseMovie(SHAWSHANK, cast);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);
        assertEquals(3, resultsCast.size(), "Expected actors in movie cast to be updated when re-released.");
    }


    @Test
    public void releaseMovie_inImdbRemoveCastMember_castUpdated() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        cast.add(WILLIAM_SADLER);
        imdb.releaseMovie(SHAWSHANK, cast);

        cast.remove(WILLIAM_SADLER);

        // WHEN
        imdb.releaseMovie(SHAWSHANK, cast);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);
        assertEquals(2, resultsCast.size(), "Expected actors in movie cast to be updated when re-released.");
    }

    @Test
    public void getActorsInMovie_notInImdb_throwsException() {
        // GIVEN - unreleased movie

        // WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> imdb.getActorsInMovie(SHAWSHANK), "Expected an exception" +
                "when getting cast for an unknown movie.");
    }

    @Test
    public void getActorsInMovie_inImdb_returnsCast() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        imdb.releaseMovie(SHAWSHANK, cast);

        // WHEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);

        // THEN
        assertEquals(2, resultsCast.size(), "Expected no duplicates actors in movie cast.");
        assertTrue(resultsCast.contains(MORGAN_COPY), "Expected to find released cast members in movie's cast.");
        assertTrue(resultsCast.contains(TIM_COPY), "Expected to find released cast members in movie's cast.");
    }
}
