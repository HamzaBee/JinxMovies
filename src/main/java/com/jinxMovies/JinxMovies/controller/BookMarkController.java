package com.jinxMovies.JinxMovies.controller;

import com.jinxMovies.JinxMovies.DTO.TmdbMovieDTO;
import com.jinxMovies.JinxMovies.entity.BookMark;
import com.jinxMovies.JinxMovies.exception.DuplicateResourceException;
import com.jinxMovies.JinxMovies.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<TmdbMovieDTO>>getUserBookmarks(@PathVariable Long userId){
        List<TmdbMovieDTO>bookmarkedMovies = bookMarkService.getBookMarkById(userId);
        return ResponseEntity.ok(bookmarkedMovies);
    }
@PostMapping("/user/{userId}/movie/{tmdbMovieId}")
    public ResponseEntity<BookMark>addBookmark(@PathVariable Long userId, @PathVariable Long tmdbMovieId){
        try {
            BookMark bookmark = bookMarkService.addBookMark(userId,tmdbMovieId);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookmark);
        }catch (DuplicateResourceException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
}
@DeleteMapping("/user/{userId}/movie/{movieId}")
    public ResponseEntity<Void> removeBookMark(@PathVariable Long userId, @PathVariable Long tmdbMovieId) {
    bookMarkService.removeBookMark(userId, tmdbMovieId);
    return ResponseEntity.noContent().build();
}
    @GetMapping("/user/{userId}/movie/{tmdbMovieId}/check")
    public ResponseEntity<Map<String, Boolean>> checkBookmarkStatus(@PathVariable Long userId, @PathVariable Long tmdbMovieId) {
        boolean isBookmarked = bookMarkService.isBookMarked(userId, tmdbMovieId);
        return ResponseEntity.ok(Map.of("bookmarked", isBookmarked));
    }

}
