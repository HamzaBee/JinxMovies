package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {
}
