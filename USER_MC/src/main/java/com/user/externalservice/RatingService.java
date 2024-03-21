package com.user.externalservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.model.Rating;

@FeignClient("https://localhost:9022")
public interface RatingService {

    @PostMapping("/rating/saveRating")
    Rating createRating(Rating rating);

    @PutMapping("")
    Rating updateRating(@RequestBody Rating rating, @PathVariable String id);

    @GetMapping("/rating/getRating/{id}")
    List<Rating> getRating(@PathVariable String id);

    @DeleteMapping("/rating/deleteRating/{id}")
    String deleteRating(@PathVariable String id);

    @GetMapping("/getAllRatings")
    public List<Rating> getAllRatings();


    @GetMapping("/rating/User/{id}")
    public List<Rating> getRatingByUserId(@PathVariable String id);

}
