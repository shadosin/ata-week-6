package com.kenzie.imdb;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void equals_inputObjectNull_returnsFalse() {
        //GIVEN
        Movie shawshank = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Movie movie = null;

        //WHEN
        boolean result = shawshank.equals(movie);

        //THEN
        assertFalse(result, "Expected checking for equality to a null object to return false.");
    }

    @Test
    void equals_inputObjectDifferentType_returnsFalse() {
        //GIVEN
        Movie shawshank = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Actor morgan = new Actor("Morgan Freeman",
                LocalDate.of(1937, 6, 1), "Memphis, Tennessee");

        //WHEN
        boolean result = shawshank.equals(morgan);

        //THEN
        assertFalse(result, "Expected checking for equality between objects of different type to return false.");
    }


    @Test
    void equals_sameObject_returnsTrue() {
        //GIVEN
        Movie shawshank = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Movie movie = shawshank;

        //WHEN
        boolean result = shawshank.equals(movie);

        //THEN
        assertTrue(result, "Expected a Movie to be equal to itself.");
    }

    @Test
    void equals_equalAttributes_returnsTrue() {
        //GIVEN
        Movie shawshank1 = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Movie shawshank2 = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));

        //WHEN
        boolean result = shawshank1.equals(shawshank2);

        //THEN
        assertTrue(result, "Movies with the same attributes should be equal.");
    }

    @Test
    void equals_notEqualName_returnsFalse() {
        //GIVEN
        Movie shawshank1 = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Movie other = new Movie("The SHAMshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));

        //WHEN
        boolean result = shawshank1.equals(other);

        //THEN
        assertFalse(result, "Movies with different names should not be equal.");
    }

    @Test
    void hashCode_equalMovieObjects_returnsSame() {
        //GIVEN
        Movie shawshank1 = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));
        Movie shawshank2 = new Movie("The Shawshank Redemption", "Frank Darabont",
                LocalDate.of(1994, 10, 14));

        //WHEN
        int shawshank1Hash = shawshank1.hashCode();
        int shawshank2Hash = shawshank2.hashCode();

        //THEN
        assertEquals(shawshank1Hash, shawshank2Hash, "Equal Movies should have the same hash codes.");
    }
}
