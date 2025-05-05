package com.jinxMovies.JinxMovies.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TmdbSearchResponseDTO {
    private int page;
    private List<TmdbMovieDTO> results;
    private int totalPages;
    private int totalResults;




    }

