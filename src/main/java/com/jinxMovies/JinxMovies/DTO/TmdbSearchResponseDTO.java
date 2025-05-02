package com.jinxMovies.JinxMovies.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TmdbSearchResponseDTO {
    private int page;
    private List<TmdbMovieDTO> results;
    private int totalPages;
    private int totalResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TmdbMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<TmdbMovieDTO> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
