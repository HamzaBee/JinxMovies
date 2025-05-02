package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "watch_history")
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime watchedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public WatchHistory(LocalDateTime watchedAt, User user, Movie movie) {
        this.watchedAt = watchedAt;
        this.user = user;
        this.movie = movie;
    }
}
