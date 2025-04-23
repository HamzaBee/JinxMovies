package com.jinxMovies.JinxMovies.controller;

import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;



    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String query){
        List<Movie> results  =movieService.searchMovies(query);
        if(results.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(results);
        }
        return ResponseEntity.ok(results);
    }

}
