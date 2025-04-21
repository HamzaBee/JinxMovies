package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;

public interface WatchListService {
    void addMovieToWatchList(Long userId, Movie movie);
    List<Movie>getAllWatchListMovies(Long userId);
    boolean isInWatchList(Long userId,Long movieId);
    void removeMovieFromWatchList(Long userId,Long movieId);
    void clearWatchList(Long userId);
}
