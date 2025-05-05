package com.jinxMovies.JinxMovies.controller;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.entity.Movie;
import com.jinxMovies.JinxMovies.service.MovieService;
import com.jinxMovies.JinxMovies.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {


    @Autowired
    private TmdbService tmdbService;

    public MovieController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }


    @GetMapping("/search")
    public List<TmdbMovieDTO> searchMovies(@RequestParam("query") String query){
        return tmdbService.searchMovies(query);
    }
    @GetMapping("/{id}")
    public TmdbMovieDTO getMovieId(@PathVariable("id") Long tmdbId){
        return  tmdbService.fetchMovieById(tmdbId);
    }
    @GetMapping("/popular")
    public List<TmdbMovieDTO> getPopularMovies(){
        return tmdbService.fetchPopularMovies();
    }
    @GetMapping("/top-rated")
    public List<TmdbMovieDTO> getTopRatedMovies() {
        return tmdbService.fetchTopRatedMovies();
    }
    @GetMapping("/{id}/similar")
    public List<TmdbMovieDTO> getSimilarMovies(@PathVariable("id") Long tmdbId) {
        return tmdbService.fetchSimilarMovies(tmdbId);
    }

}
