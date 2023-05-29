package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagActorTest extends ImdbTest {

    @Test
    public void tagActorInMovie_inImdb_actorAddedToCast() {
        // GIVEN
        Set<Actor> cast = new HashSet<>();
        cast.add(MORGAN_FREEMAN);
        cast.add(TIM_ROBBINS);
        imdb.releaseMovie(SHAWSHANK, cast);

        // WHEN
        imdb.tagActorInMovie(SHAWSHANK_COPY, WILLIAM_SADLER);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK);
        assertEquals(3, resultsCast.size(), "Expected actors in movie cast to be updated new actor tagged.");
    }

    @Test
    public void tagActorInMovie_notInImdb_actorOnlyCastMember() {
        // WHEN
        imdb.tagActorInMovie(SHAWSHANK, WILLIAM_SADLER);

        // THEN
        Set<Actor> resultsCast = imdb.getActorsInMovie(SHAWSHANK_COPY);
        assertEquals(1, resultsCast.size(), "Expected single actor in movie cast when tagging an actor in an unreleased movie.");
    }
}
