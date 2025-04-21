package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.WatchHistory;
import com.jinxMovies.JinxMovies.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,Long> {
    List<WatchList> findByUserId(Long userId);
    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
    void deleteByUserIdAndMovieId(Long userId, Long movieId);
}
