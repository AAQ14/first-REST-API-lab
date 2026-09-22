# Movies

## Description
Movies app is a simple Spring Boot REST API that manages the list of movies. The application uses a linked list to store the movie data.
This API allow the users to create, get, update, delete, filter the data and get statistics about movies.

## Technologies
* Spring Boot
* Java
* Maven
* REST API

## End Points
### There are 10 end points implemented: 
* GET /api/welcome get the application profile
* GET  /api/movies/ get all the movies in the list
* GET /api/movies/{movieId} get specific movie by id
* GET /api/movies/search/{movieTitle} get a movie by its name
* GET /api/movies/filter?genre="" get the filtered movies by genre
* POST /api/movies/create create a new movie and add it to the list
* PUT /api/movies/{movieId} update a movie by specifying the id
* DELETE /api/movies/{movieId} delete a movie by specifying the id
* GET /api/movies/stats get the statistics of the movies like: total number of movies, average rating and the highest rating.
* GET /api/movies/random get a random movie from the list

## Instructions for running the project
* Java installed
* Maven installed
* IDE like IntelliJ or Visual Studio Code

* clone or download the project.
* open the project in IDE.
* run the Spring Boot application.
* the app will run locally usually at http://localhost:8080 .
* use tool like postman to test the end points.
