package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private Long tmdbMovieId;

    @Column(nullable = false)
    private String movieTitle;

    @Column
    private String posterPath;

    public BookMark(User user, Long tmdbMovieId, String movieTitle, String posterPath) {
        this.user = user;
        this.tmdbMovieId = tmdbMovieId;
        this.movieTitle = movieTitle;
        this.posterPath = posterPath;
    }


}
