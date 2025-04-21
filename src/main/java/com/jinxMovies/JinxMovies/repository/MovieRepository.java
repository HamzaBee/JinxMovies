package com.jinxMovies.JinxMovies.repository;

import com.jinxMovies.JinxMovies.entity.Movie;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
