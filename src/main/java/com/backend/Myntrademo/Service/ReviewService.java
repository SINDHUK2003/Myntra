package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Review;
import com.backend.Myntrademo.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;


    public Review addReview(Review review)
    {
        return reviewRepo.save(review);
    }

    public void deleteReview(int reviewid)
    {
        reviewRepo.deleteById(reviewid);
    }

    public Review getReview(int reviewid)
    {
        Optional<Review> dispReview = reviewRepo.findById(reviewid);
        return dispReview.orElse(null);
    }

    public Review updateReview(int reviewid, Review review)
    {
        Review review1 = reviewRepo.findById(reviewid).orElseThrow(() -> new RuntimeException("Review not found with ReviewId:" + reviewid));

        review1.setTitle(review.getTitle());
        review1.setDescription((review.getDescription()));
        review1.setRating(review.getRating());

        return reviewRepo.save(review1);

    }


}
