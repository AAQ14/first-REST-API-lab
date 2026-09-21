package com.ga.movies.models;

public class MoviesModel {
    private int id;
    private String title;
    private String genre;
    private int year;
    private double rating;

    public MoviesModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "movie id: " + getId() +", " +
                "movie name: " + getTitle() +", " +
                "movie genre: " + getGenre() +", " +
                "movie released date: " + getYear() +", " +
                "rating: " + getRating() +". ";
    }
}
