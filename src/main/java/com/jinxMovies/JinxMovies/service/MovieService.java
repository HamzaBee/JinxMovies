package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    TmdbMovieDTO fetchMovieFromTMDb(Long tmdbId);

    // Searches movies from TMDb API and returns the results as TmdbMovieDTO
    List<TmdbMovieDTO> searchMovies(String query);

    // Fetches a movie by title from TMDb
    TmdbMovieDTO fetchMovieByTitle(String title);

    // Fetches popular movies from TMDb API
    List<TmdbMovieDTO> fetchPopularMovies();

    // Fetches top-rated movies from TMDb API
    List<TmdbMovieDTO> fetchTopRatedMovies();

    // Fetches similar movies from TMDb API based on a given TMDb ID
    List<TmdbMovieDTO> fetchSimilarMovies(Long tmdbId);

}



