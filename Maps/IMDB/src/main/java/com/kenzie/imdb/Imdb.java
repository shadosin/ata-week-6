package com.kenzie.imdb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Stores the relationships between movies and actors, allowing releasing a new movie
 * with all actors in the cast, adding a single actor to an existing (or new) movie,
 * unreleasing a movie completely, and querying actors by movie and vice versa.
 */
public class Imdb {

    private Map<Movie, Set<Actor>> moviesToActors = new HashMap<>();
    private Map<Actor, Set<Movie>> actorsToMovies = new HashMap<>();

    //TODO: Implement this method
    /**
     * Adds the new movie to the set of movies that an actor has appeared in.
     * If the movie already exists in the database, this will overwrite actors
     * associated with the movie with the new values provided.
     *
     * @param movie the movie being released
     * @param actors a set of actors that appear in the movie
     */
    public void releaseMovie(Movie movie, Set<Actor> actors) {
        moviesToActors.put(movie, actors);

        for(Actor actor: actors){
            Set<Movie> movies = actorsToMovies.getOrDefault(actor, new HashSet<>());
            movies.add(movie);
            actorsToMovies.put(actor, movies);
        }

    }

    // TODO: Implement this method
    /**
     * Removes the given movie from the database, including any actors
     * credited in the movie.
     *
     * @param movie the movie to remove
     * @return true if the movie was removed, false if it wasn't in Imdb
     *         to begin with
     */
    public boolean removeMovie(Movie movie) {
        Set<Actor> actors = moviesToActors.remove(movie);
        if (actors != null){
            for(Actor actor : actors){
                Set<Movie> movies = actorsToMovies.get(actor);
                if(movies != null){
                    movies.remove(movie);
                    if(movies.isEmpty()){
                        actorsToMovies.remove(actor);
                    }
                }
            }
            return true;
        }
        return false;
    }

    // TODO: Implement this method
    /**
     * Adds a new movie to the set of movies that an actor has appeared in.
     * If the movie already exists in the database, will add the actor
     * if they haven't been added already. If the movie doesn't yet exist
     * in the database, this will add the movie with the actor as the only
     * credit.
     *
     * @param movie the movie to add to the actors set of movies
     * @param actor the actor that appears in this movie
     */
    public void tagActorInMovie(Movie movie, Actor actor) {
        Set<Actor> actors = moviesToActors.getOrDefault(movie, new HashSet<>());
        actors.add(actor);
        moviesToActors.put(movie, actors);

        Set<Movie> movies = actorsToMovies.getOrDefault(actor, new HashSet<>());
        movies.add(movie);
        actorsToMovies.put(actor, movies);
    }

    //TODO: Implement this method
    /**
     * Returns a set of actors who are credited in the given movie. If a movie is not
     * released on IMDB throw an IllegalArgumentException.
     *
     * @param movie the movie to get actors for
     * @return the set of actors who are credited in the passed in movie
     */
    public Set<Actor> getActorsInMovie(Movie movie) {
        if(moviesToActors.containsKey(movie)){
            return moviesToActors.get(movie);
        }else{
            throw new IllegalArgumentException("Movie not found in the database");
        }
    }

    // TODO: Implement this method
    /**
     * Returns a set of movies that the specified actor has appeared in. If the
     * actor has not appeared in any movies, return an empty Set.
     *
     * @param actor the actor to get movies for
     * @return the set of movies that the passed in actor has appeared in
     */
    public Set<Movie> getMoviesForActor(Actor actor) {
        return actorsToMovies.getOrDefault(actor, new HashSet<>());
    }

    // TODO: Implement this method
    /**
     * Returns all actors that IMDB has in its records as having appeared in a movie.
     *
     * @return a set of actors that IMDB has as appeared in movies
     */
    public Set<Actor> getAllActorsInIMDB() {
        return actorsToMovies.keySet();
    }

    // TODO: Implement this method
    /**
     * Returns the total number of individual movie-actor pairs in the database.
     *
     * So if there are 2 movies, the first movie has 1 actor and the second one
     * has 6 actors, this method will return 7.
     *
     * @return The total number of movie-actor pairings: the number of times
     *         any actor has appeared in any movie
     */
    public int getTotalNumCredits() {
        int totalCredits = 0;
        for(Set<Movie> movies : actorsToMovies.values()){
            totalCredits += movies.size();
        }
        return totalCredits;
    }
}
