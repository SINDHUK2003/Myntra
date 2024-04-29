package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.CreateReviewDTO;
import com.backend.Myntrademo.Entity.Review;
import com.backend.Myntrademo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<Review> createReview(@RequestBody CreateReviewDTO createReviewDTO) {
        Review review = reviewService.createReview(createReviewDTO);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/getReview/{reviewid}")
    public Review getReview(@PathVariable("reviewid") int reviewid)
    {
        return reviewService.getReview((reviewid));
    }

    @DeleteMapping("/deleteReview/{reviewid}")
    public String deleteReview(@PathVariable("reviewid") int reviewid)
    {
        reviewService.deleteReview(reviewid);
        return "Review deleted";
    }

    @GetMapping("/getAllReviews")
    public List<Review> getAllReview()
    {
        return reviewService.getAllReview();
    }

    @PutMapping("/updateReview/{reviewid}")
    public Review updateReview(@PathVariable("reviewid") int reviewid, @RequestBody Review review)
    {
        return reviewService.updateReview(reviewid, review);
    }


}