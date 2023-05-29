package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataDumpTest extends ImdbTest {

    @Test
    public void getAllActorsInIMDB_noMoviesInImdb_noActorsReturned() {
        // WHEN
        Set<Actor> actors = imdb.getAllActorsInIMDB();

        // THEN
        assertTrue(actors.isEmpty(), "Expected no actors in IMDB when no movies released.");
    }

    @Test
    public void getAllActorsInIMDB_moviesInImdb_allActorsReturned() {
        // GIVEN
        Set<Actor> bucketCast = new HashSet<>();
        bucketCast.add(MORGAN_FREEMAN);

        Set<Actor> shawshankCast = new HashSet<>();
        shawshankCast.add(MORGAN_FREEMAN);
        shawshankCast.add(TIM_ROBBINS);
        shawshankCast.add(WILLIAM_SADLER);

        Set<Actor> goneBabyGoneCast = new HashSet<>();
        goneBabyGoneCast.add(CASEY_AFFLECK);
        goneBabyGoneCast.add(MORGAN_FREEMAN);

        imdb.releaseMovie(BUCKET_LIST, bucketCast);
        imdb.releaseMovie(SHAWSHANK, shawshankCast);
        imdb.releaseMovie(GONE_BABY_GONE, goneBabyGoneCast);

        // WHEN
        Set<Actor> actors = imdb.getAllActorsInIMDB();

        // THEN
        assertEquals(4, actors.size(), "Expected a unique set of actors in IMDB.");
    }

    @Test
    public void getTotalNumCredits_noMoviesInImdb_countZero() {
        // WHEN
        int credits = imdb.getTotalNumCredits();

        // THEN
        assertEquals(0, credits, "Expected no credits in IMDB when no movies released.");
    }

    @Test
    public void getTotalNumCredits_moviesInImdb_countReturned() {
        // GIVEN
        Set<Actor> bucketCast = new HashSet<>();
        bucketCast.add(MORGAN_FREEMAN);

        Set<Actor> shawshankCast = new HashSet<>();
        shawshankCast.add(MORGAN_FREEMAN);
        shawshankCast.add(TIM_ROBBINS);
        shawshankCast.add(WILLIAM_SADLER);

        Set<Actor> goneBabyGoneCast = new HashSet<>();
        goneBabyGoneCast.add(CASEY_AFFLECK);
        goneBabyGoneCast.add(MORGAN_FREEMAN);

        imdb.releaseMovie(BUCKET_LIST, bucketCast);
        imdb.releaseMovie(SHAWSHANK, shawshankCast);
        imdb.releaseMovie(GONE_BABY_GONE, goneBabyGoneCast);

        // WHEN
        int credits = imdb.getTotalNumCredits();

        // THEN
        assertEquals(6, credits, "Expected an actor to get a credit for each movie appeared in.");
    }
}
