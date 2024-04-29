package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.CreateReviewDTO;
import com.backend.Myntrademo.Entity.Review;
import com.backend.Myntrademo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<Review> createReview(@RequestBody CreateReviewDTO createReviewDTO) {
        Review review = reviewService.createReview(createReviewDTO);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

}