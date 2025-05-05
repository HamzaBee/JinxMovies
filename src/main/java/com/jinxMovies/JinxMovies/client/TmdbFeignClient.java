package com.jinxMovies.JinxMovies.client;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.DTO.TmdbSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tmdbClient", url = "https://api.themoviedb.org/3")
public interface TmdbFeignClient {

    @GetMapping("/search/movie")
    TmdbSearchResponseDTO searchMovies(
            @RequestParam("language") String language,   // changed 'Language' to lowercase
            @RequestParam("page") int page,
            @RequestParam("include_adult") boolean includeAdult,
            @RequestParam("query") String query
    );

    @GetMapping("/movie/popular")
    TmdbSearchResponseDTO fetchPopularMovies(
            @RequestParam("language") String language,
            @RequestParam("page") int page
    );

    @GetMapping("/movie/top_rated")
    TmdbSearchResponseDTO fetchTopRated(
            @RequestParam("language") String language,
            @RequestParam("page") int page
    );

    @GetMapping("/movie/{tmdbId}/similar")
    TmdbSearchResponseDTO fetchSimilarMovie(
            @PathVariable("tmdbId") Long tmdbId,
            @RequestParam("language") String language,
            @RequestParam("page") int page
    );

    @GetMapping("/movie/{tmdbId}/recommendations")
    TmdbSearchResponseDTO fetchMovieRecommendations(
            @PathVariable("tmdbId") Long tmdbId,
            @RequestParam("language") String language,
            @RequestParam("page") int page
    );

    @GetMapping("/movie/{tmdbId}")
    TmdbMovieDTO fetchMovieById(
            @PathVariable("tmdbId") Long tmdbId,
            @RequestParam("language") String language
    );
}

