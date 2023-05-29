package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetMoviesTest extends ImdbTest {
    @Test
    public void getMoviesForActor_actorHasCredits_moviesReturned() {
        // GIVEN
        Set<Actor> bucketCast = new HashSet<>();
        bucketCast.add(MORGAN_FREEMAN);

        Set<Actor> shawshankCast = new HashSet<>();
        shawshankCast.add(MORGAN_FREEMAN);
        shawshankCast.add(TIM_ROBBINS);

        imdb.releaseMovie(BUCKET_LIST, bucketCast);
        imdb.releaseMovie(SHAWSHANK, shawshankCast);

        // WHEN
        Set<Movie> movies = imdb.getMoviesForActor(MORGAN_COPY);

        // THEN
        assertEquals(2, movies.size(), "Expected actor to appear in multiple released movies.");
    }

    @Test
    public void getMoviesForActor_actorHasNoCredits_noMoviesReturned() {
        // WHEN
        Set<Movie> movies = imdb.getMoviesForActor(MORGAN_FREEMAN);

        // THEN
        assertTrue(movies.isEmpty(), "Expected no movies to be returned for an actor without released movies.");
    }

    @Test
    public void getMoviesForActor_taggedInKnownImdbMovie_movieAddedToActorCredits() {
        // GIVEN
        Set<Actor> bucketCast = new HashSet<>();
        bucketCast.add(MORGAN_FREEMAN);

        Set<Actor> shawshankCast = new HashSet<>();
        shawshankCast.add(MORGAN_FREEMAN);
        shawshankCast.add(TIM_ROBBINS);

        Set<Actor> goneBabyGoneCast = new HashSet<>();
        goneBabyGoneCast.add(CASEY_AFFLECK);

        imdb.releaseMovie(BUCKET_LIST, bucketCast);
        imdb.releaseMovie(SHAWSHANK, shawshankCast);
        imdb.releaseMovie(GONE_BABY_GONE, goneBabyGoneCast);

        imdb.tagActorInMovie(GONE_BABY_GONE, MORGAN_FREEMAN);

        // WHEN
        Set<Movie> movies = imdb.getMoviesForActor(MORGAN_COPY);

        // THEN
        assertEquals(3, movies.size(), "Expected actor to appear in movies they are tagged in.");
    }



    @Test
    public void getMoviesForActor_taggedInUnknownImdbMovie_movieAddedToActorCredits() {
        // GIVEN
        Set<Actor> bucketCast = new HashSet<>();
        bucketCast.add(MORGAN_FREEMAN);

        Set<Actor> shawshankCast = new HashSet<>();
        shawshankCast.add(MORGAN_FREEMAN);
        shawshankCast.add(TIM_ROBBINS);

        imdb.releaseMovie(BUCKET_LIST, bucketCast);
        imdb.releaseMovie(SHAWSHANK, shawshankCast);

        imdb.tagActorInMovie(GONE_BABY_GONE, MORGAN_FREEMAN);

        // WHEN
        Set<Movie> movies = imdb.getMoviesForActor(MORGAN_COPY);

        // THEN
        assertEquals(3, movies.size(), "Expected actor to appear in movies they are tagged in.");
    }
}
