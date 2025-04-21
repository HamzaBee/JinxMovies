package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,Long> {
}
