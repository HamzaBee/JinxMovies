package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.Movie;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title); // Search by title
    List<Movie> findByGenre(String genre);
    List<Movie> findTop10ByOrderByReleaseDateDesc();
    List<Movie> findTop10ByOrderByRatingDesc();
}
