package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.entity.User;

import java.util.List;

public interface WatchHistoryService {
    List<Movie>getWatchedMovies(Long userId);
    void addToWatchHistory(Long userId, Movie movie);
    boolean isMovieAlreadyWatched(Long userId, Long movieId);
    void clearWatchHistory(Long userId);
    void removeMovieFromWatchedHistory(Long userId,Long movieId);
}
