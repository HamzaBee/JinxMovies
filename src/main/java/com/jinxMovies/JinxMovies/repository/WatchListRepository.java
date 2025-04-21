package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.WatchHistory;
import com.jinxMovies.JinxMovies.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {
    List<WatchHistory> findByUserIdOrderByWatchedAtDesc(Long userId);
    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
    long countByUserId(Long userId);
}
