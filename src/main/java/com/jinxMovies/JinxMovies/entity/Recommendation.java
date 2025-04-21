package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Movie movie;
     @ManyToOne
     @JoinColumn()
     private User user;




}
