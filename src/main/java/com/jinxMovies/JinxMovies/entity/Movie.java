package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;

@Entity
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




}
