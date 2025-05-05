package com.jinxMovies.JinxMovies.service;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.DTO.TmdbSearchResponseDTO;
import com.jinxMovies.JinxMovies.client.TmdbFeignClient;
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


   private final TmdbFeignClient tmdbClient;

    public TmdbService(TmdbFeignClient tmdbClient) {
        this.tmdbClient = tmdbClient;

    }

    public List<TmdbMovieDTO> searchMovies(String query){
        TmdbSearchResponseDTO responseDTO = tmdbClient.searchMovies("en-US",1,false,query);
        return responseDTO != null ? responseDTO.getResults() : Collections.emptyList();
    }
    public TmdbMovieDTO fetchMovieById(Long tmdbId) {
        return tmdbClient.fetchMovieById(tmdbId, "en-US");
    }


    public List<TmdbMovieDTO> fetchPopularMovies(){
        TmdbSearchResponseDTO responseDTO = tmdbClient.fetchPopularMovies("en-US", 1);
        return responseDTO != null ? responseDTO.getResults() : Collections.emptyList();
    }
    public List<TmdbMovieDTO> fetchTopRatedMovies(){
        TmdbSearchResponseDTO responseDTO = tmdbClient.fetchTopRated("en-US", 1);
        return responseDTO != null ? responseDTO.getResults() : Collections.emptyList();
    }
    public List<TmdbMovieDTO> fetchSimilarMovies(Long tmdbId) {
        TmdbSearchResponseDTO response = tmdbClient.fetchSimilarMovie(tmdbId, "en-US", 1);
        return response != null ? response.getResults() : Collections.emptyList();
    }


}
