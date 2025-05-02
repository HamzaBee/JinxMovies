package com.jinxMovies.JinxMovies.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TmdbMovieDTO {
    private Long id;
    private boolean adult;
    private String backdropPath;
    private List<Integer> genreIds;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;

}
