package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {
    @Test
    void equals_inputObjectNull_returnsFalse() {
        //GIVEN
        Actor morgan = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Actor actor = null;

        //WHEN
        boolean result = morgan.equals(actor);

        //THEN
        assertFalse(result, "Expected checking for equality to a null object to return false.");
    }

    @Test
    void equals_inputObjectDifferentType_returnsFalse() {
        //GIVEN
        Actor morgan = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Movie shawshank = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));

        //WHEN
        boolean result = morgan.equals(shawshank);

        //THEN
        assertFalse(result, "Expected checking for equality between objects of different type to return false.");
    }


    @Test
    void equals_sameObject_returnsTrue() {
        //GIVEN
        Actor morgan = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Actor actor = morgan;

        //WHEN
        boolean result = morgan.equals(actor);

        //THEN
        assertTrue(result, "Expected a Movie to be equal to itself.");
    }

    @Test
    void equals_equalAttributes_returnsTrue() {
        //GIVEN
        Actor morgan1 = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Actor morgan2 = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");

        //WHEN
        boolean result = morgan1.equals(morgan2);

        //THEN
        assertTrue(result, "Actors with the same attributes should be equal.");
    }

    @Test
    void equals_notEqualName_returnsFalse() {
        //GIVEN
        Actor morgan = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Actor other = new Actor("Forgan Mreeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");

        //WHEN
        boolean result = morgan.equals(other);

        //THEN
        assertFalse(result, "Actors with different names should not be equal.");
    }

    @Test
    void hashCode_equalActorObjects_returnsSame() {
        //GIVEN
        Actor morgan1 = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");
        Actor morgan2 = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");

        //WHEN
        int morgan1Hash = morgan1.hashCode();
        int morgan2Hash = morgan2.hashCode();

        //THEN
        assertEquals(morgan1Hash, morgan2Hash, "Equal Actors should have the same hash codes.");
    }
}
