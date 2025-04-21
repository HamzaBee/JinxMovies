package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie fetchMovieFromTMDb(Long tmdbId);
    List<Movie>searchMovie(String query);






}
