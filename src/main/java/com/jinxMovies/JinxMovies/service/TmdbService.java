package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.DTO.TmdbSearchResponseDTO;
import com.jinxMovies.JinxMovies.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Service
public class TmdbService {


    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    @Value("${tmdb.api.key}")
    private String apiKey;


    public TmdbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TmdbMovieDTO> searchMovies(String query) {
        String url = BASE_URL + "/search/movie?api_key=" + apiKey +
                "&language=en-US&page=1&include_adult=false&query=" + UriUtils.encode(query, StandardCharsets.UTF_8);
        TmdbSearchResponseDTO response = restTemplate.getForObject(url, TmdbSearchResponseDTO.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    // Fetch a movie by its TMDb ID
    public TmdbMovieDTO fetchMovieById(Long tmdbId) {
        String url = BASE_URL + "/movie/" + tmdbId + "?api_key=" + apiKey + "&language=en-US";
        return restTemplate.getForObject(url, TmdbMovieDTO.class);
    }

    // Fetch popular movies
    public List<TmdbMovieDTO> fetchPopularMovies() {
        String url = BASE_URL + "/movie/popular?api_key=" + apiKey + "&language=en-US&page=1";
        TmdbSearchResponseDTO response = restTemplate.getForObject(url, TmdbSearchResponseDTO.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    // Fetch top rated movies
    public List<TmdbMovieDTO> fetchTopRatedMovies() {
        String url = BASE_URL + "/movie/top_rated?api_key=" + apiKey + "&language=en-US&page=1";
        TmdbSearchResponseDTO response = restTemplate.getForObject(url, TmdbSearchResponseDTO.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    // Fetch similar movies to a given movie ID
    public List<TmdbMovieDTO> fetchSimilarMovies(Long tmdbId) {
        String url = BASE_URL + "/movie/" + tmdbId + "/similar?api_key=" + apiKey + "&language=en-US&page=1";
        TmdbSearchResponseDTO response = restTemplate.getForObject(url, TmdbSearchResponseDTO.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    // Fetch recommended movies for a given movie ID
    public List<TmdbMovieDTO> fetchMovieRecommendations(Long tmdbId) {
        String url = BASE_URL + "/movie/" + tmdbId + "/recommendations?api_key=" + apiKey + "&language=en-US&page=1";
        TmdbSearchResponseDTO response = restTemplate.getForObject(url, TmdbSearchResponseDTO.class);
        return response != null ? response.getResults() : Collections.emptyList();

    }
}
