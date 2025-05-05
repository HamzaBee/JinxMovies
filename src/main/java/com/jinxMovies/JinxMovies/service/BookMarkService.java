package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.entity.BookMark;
import com.jinxMovies.JinxMovies.entity.Movie;

import java.util.List;

public interface BookMarkService {
    List<BookMark> getBookmarksByUserId(Long userId);
    BookMark addBookMark(Long userId, Long tmdbMovieId);
    void removeBookMark(Long userId, Long tmdbMovieId);
    List<TmdbMovieDTO>getBookMarkById(Long userId);
    boolean isBookMarked(Long userId, Long tmdbMovieId);


}
