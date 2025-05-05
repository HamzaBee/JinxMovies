package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String algorithmUsed;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "recommendation_movies",
            joinColumns = @JoinColumn(name = "recommendation_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> recommendedMovies;


}


