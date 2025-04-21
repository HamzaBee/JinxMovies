package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.entity.BookMark;
import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;

public interface BookMarkService {

    BookMark addBookMark(Long userId, Long tmdbMovieId);
    void removeBookMark(Long userId, Long tmdbMovieId);
    List<Movie>getBookMarkById(Long userId);
    boolean isBookMarked(Long userId, Long tmdbMovieId);


}
