package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String posterUrl;
    private String genre;
    private String description;
    private double rating;
    private String releaseDay;


    public Movie(String title, String posterUrl, String genre, String description, double rating, String releaseDay) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.releaseDay = releaseDay;
    }


}
