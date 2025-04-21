package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie fetchMovieFromTMDb(Long tmdbId);
    Optional<Movie>getTmbdMovieById(Long id);
     List<Movie> searchMovies(String query);
     Movie fetchMovieByTitle(String title);
     List<Movie> fetchPopularMovies();
     List<Movie> fetchTopRatedMovies();
     List<Movie> fetchSimilarMovies(Long tmdbId);
     List<Movie> fetchMovieRecommendations(Long tmdbId);






}
