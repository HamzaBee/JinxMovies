package com.jinxMovies.JinxMovies.service.Impl;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.client.TmdbFeignClient;
import com.jinxMovies.JinxMovies.entity.BookMark;
import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.entity.User;
import com.jinxMovies.JinxMovies.exception.DuplicateResourceException;
import com.jinxMovies.JinxMovies.exception.ResourceNotFoundException;
import com.jinxMovies.JinxMovies.repository.BookMarkRepository;
import com.jinxMovies.JinxMovies.repository.MovieRepository;
import com.jinxMovies.JinxMovies.repository.UserRepository;
import com.jinxMovies.JinxMovies.service.BookMarkService;
import com.jinxMovies.JinxMovies.service.TmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BookMarkImpl implements BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;
    private final TmdbService tmdbService;


    @Override
    public List<BookMark> getBookmarksByUserId(Long userId) {
        return bookMarkRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public BookMark addBookMark(Long userId, Long tmdbMovieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found" + userId));
        if(isBookMarked(userId,tmdbMovieId)){
            throw new DuplicateResourceException("Movie is already bookmarked by user ");
        }
        TmdbMovieDTO tmdbMovie = tmdbService.fetchMovieById(tmdbMovieId);
        if (tmdbMovie == null){
            throw new ResourceNotFoundException("Movie not found with id: " + tmdbMovieId);
        }
        BookMark bookMark = new BookMark(user, tmdbMovieId,tmdbMovie.getTitle(), tmdbMovie.getPosterPath());
        return bookMarkRepository.save(bookMark);

    }

    @Override
    @Transactional
    public void removeBookMark(Long userId, Long tmdbMovieId) {
        BookMark bookMark = bookMarkRepository.findByUserIdAndTmdbMovieId(userId,tmdbMovieId)
                .orElseThrow(()->new ResourceNotFoundException("Bookmark not found for user id: " + userId + " and movie id: " + tmdbMovieId));
        bookMarkRepository.delete(bookMark);


    }

    @Override
    public List<TmdbMovieDTO> getBookMarkById(Long userId) {
        List<BookMark> bookMarks = bookMarkRepository.findByUserId(userId);
        return bookMarks.stream()
                .map(bookMark -> tmdbService.fetchMovieById(bookMark.getTmdbMovieId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isBookMarked(Long userId, Long tmdbMovieId) {
        return bookMarkRepository.existsByUserIdAndTmdbMovieId(userId,tmdbMovieId);
    }
}
