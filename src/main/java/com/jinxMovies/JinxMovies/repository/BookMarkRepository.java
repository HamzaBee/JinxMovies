package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookMarkRepository extends JpaRepository<BookMark,Long> {
    List<BookMark> findByUserId(Long userId);
    Optional<BookMark> findByUserIdAndTmdbMovieId(Long userId, Long tmdbMovieId);
    boolean existsByUserIdAndTmdbMovieId(Long userId, Long tmdbMovieId);
}
