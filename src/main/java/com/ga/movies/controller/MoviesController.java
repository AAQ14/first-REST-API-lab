package com.ga.movies.controller;

import com.ga.movies.models.MoviesModel;
import com.ga.movies.models.ProfileModel;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MoviesController {

    private LinkedList<MoviesModel> moviesList = new LinkedList<MoviesModel>();

    public MoviesController() {
        MoviesModel movie1 = new MoviesModel();
        movie1.setId(1);
        movie1.setTitle("Fast & Furious");
        movie1.setGenre("Action");
        movie1.setYear(2001);
        movie1.setRating(8);
        moviesList.add(movie1);

        MoviesModel movie2 = new MoviesModel();
        movie2.setId(2);
        movie2.setTitle("Coco");
        movie2.setGenre("Family/Fantasy");
        movie2.setYear(2017);
        movie2.setRating(8.4);
        moviesList.add(movie2);

        MoviesModel movie3 = new MoviesModel();
        movie3.setId(3);
        movie3.setTitle("Shrek");
        movie3.setGenre("Comedy/Family");
        movie3.setYear(2001);
        movie3.setRating(7.9);
        moviesList.add(movie3);

        MoviesModel movie4 = new MoviesModel();
        movie4.setId(4);
        movie4.setTitle("Kung Fu Panda");
        movie4.setGenre("Comedy/Family");
        movie4.setYear(2001);
        movie4.setRating(8);
        moviesList.add(movie4);
    }

    @GetMapping(path ="/welcome")
    public String welcome(){
        ProfileModel profile = new ProfileModel();
        return profile.toString();
    }

    //get all items
    @GetMapping(path ="/movies/")
    public LinkedList<MoviesModel> getAllMovies(){
        return moviesList;
    }

    //get one item by id
    @GetMapping(path = "/movies/{movieId}")
    public Optional<MoviesModel>  getMovie(@PathVariable int movieId){
        return moviesList.stream().filter(movie-> movie.getId() == movieId)
                .findFirst();
    }

    //search
    @GetMapping(path = "/movies/search/{movieTitle}")
    public Optional<MoviesModel> search(@PathVariable String movieTitle){
        return moviesList.stream().filter(movie -> movie.getTitle().toLowerCase().contains(movieTitle.toLowerCase())).findFirst();
    }

    //filter based on the genre
    @GetMapping(path = "/movies/filter")
    public List<MoviesModel> filter(@RequestParam String genre){
        return moviesList.stream().filter(movie -> movie.getGenre().toLowerCase().contains(genre.toLowerCase())).collect(Collectors.toList());
    }

    //create movie
    @PostMapping(path = "/movies/create")
    public MoviesModel createMovie(@RequestBody MoviesModel movie){
        moviesList.add(movie);
        return movie;
    }

    //update movie
    @PutMapping(path = "/movies/{movieId}")
    public ResponseEntity<MoviesModel> update(@PathVariable int movieId, @RequestBody  MoviesModel movieObject){
        Optional<MoviesModel> movie = moviesList.stream().filter(movie1 -> movie1.getId() == movieId).findAny();
        if (movie.isPresent()){
            MoviesModel existMovie = movie.get();
            existMovie.setTitle(movieObject.getTitle());
            existMovie.setRating(movieObject.getRating());
            existMovie.setYear(movieObject.getYear());
            existMovie.setGenre(movieObject.getGenre());

            return ResponseEntity.ok(existMovie);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Delete
    @DeleteMapping("/movies/{movieId}")
    public MoviesModel deleteMovie(@PathVariable int movieId){
        Optional<MoviesModel> movie =  moviesList.stream().filter(movie1 -> movie1.getId() == movieId).findAny();

        if(movie.isPresent()){
            moviesList.remove(movie.get());
            return movie.get();
        }else{
            throw new RuntimeException("Movie with id " + movieId + " not found");
        }
    }

    //statistics
    @GetMapping("/movies/stats")
    public HashMap<String, Double> getStats(){
        HashMap<String, Double> moviesStats = new HashMap<String, Double>();
        Double totalMovies = (double) moviesList.size();
        Double avgRating = moviesList.stream().mapToDouble(movie1 -> movie1.getRating()).average().orElse(0);
        Double highestRate = moviesList.stream().mapToDouble(movie1 -> movie1.getRating()).max().orElse(0);
        moviesStats.put("movies total", totalMovies);
        moviesStats.put("average rating", avgRating);
        moviesStats.put("highest rate", highestRate);

        return moviesStats;
    }

    //own feature
    @GetMapping("/movies/random")
    public MoviesModel getRandomMovie(){
        Random random = new Random();
        int randomIndex = random.nextInt(moviesList.size());
        return moviesList.get(randomIndex);
    }
}
