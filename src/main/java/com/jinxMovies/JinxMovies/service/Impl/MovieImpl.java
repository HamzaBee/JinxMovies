package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.service.MovieService;
import com.jinxMovies.JinxMovies.service.TmdbService;

import java.util.List;
import java.util.Optional;

public class MovieImpl implements MovieService {


    private final TmdbService tmdbService;

    public MovieImpl(TmdbService tmdbService) {
        this.tmdbService = tmdbService;

    }


    @Override
    public TmdbMovieDTO fetchMovieFromTMDb(Long tmdbId) {
        return tmdbService.fetchMovieById(tmdbId);
    }

    @Override
    public List<TmdbMovieDTO> searchMovies(String query) {
        return tmdbService.searchMovies(query);
    }

    @Override
    public TmdbMovieDTO fetchMovieByTitle(String title) {
        // Assuming you would implement title-based search logic through the API
        List<TmdbMovieDTO> results = tmdbService.searchMovies(title);
        return results.isEmpty() ? null : results.get(0); // return the first movie found
    }

    @Override
    public List<TmdbMovieDTO> fetchPopularMovies() {
        return tmdbService.fetchPopularMovies();
    }

    @Override
    public List<TmdbMovieDTO> fetchTopRatedMovies() {
        return tmdbService.fetchTopRatedMovies();
    }

    @Override
    public List<TmdbMovieDTO> fetchSimilarMovies(Long tmdbId) {
        return tmdbService.fetchSimilarMovies(tmdbId);
    }

    @Override
    public List<TmdbMovieDTO> fetchMovieRecommendations(Long tmdbId) {
        return tmdbService.fetchMovieRecommendations(tmdbId);
    }
}
