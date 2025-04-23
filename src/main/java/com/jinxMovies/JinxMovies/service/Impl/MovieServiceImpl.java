package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.repository.UserRepository;
import com.jinxMovies.JinxMovies.service.MovieService;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    private final UserRepository userRepository;

    public MovieServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Movie fetchMovieFromTMDb(Long tmdbId) {
        return userRepository.;
    }

    @Override
    public Optional<Movie> getTmbdMovieById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> searchMovies(String query) {
        return List.of();
    }

    @Override
    public Movie fetchMovieByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> fetchPopularMovies() {
        return List.of();
    }

    @Override
    public List<Movie> fetchTopRatedMovies() {
        return List.of();
    }

    @Override
    public List<Movie> fetchSimilarMovies(Long tmdbId) {
        return List.of();
    }

    @Override
    public List<Movie> fetchMovieRecommendations(Long tmdbId) {
        return List.of();
    }
}
