package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.service.WatchListService;

import java.util.List;

public class WatchListImpl implements WatchListService {
    @Override
    public void addMovieToWatchList(Long userId, Movie movie) {

    }

    @Override
    public List<Movie> getAllWatchListMovies(Long userId) {
        return List.of();
    }

    @Override
    public boolean isInWatchList(Long userId, Long movieId) {
        return false;
    }

    @Override
    public void removeMovieFromWatchList(Long userId, Long movieId) {

    }

    @Override
    public void clearWatchList(Long userId) {

    }
}
