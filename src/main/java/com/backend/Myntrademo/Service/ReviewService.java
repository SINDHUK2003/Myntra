package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.DTO.CreateReviewDTO;
import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Entity.Review;
import com.backend.Myntrademo.Enum.Rating;
import com.backend.Myntrademo.Repository.GalleryRepo;
import com.backend.Myntrademo.Repository.ProductRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import com.backend.Myntrademo.Repository.ReviewRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private GalleryRepo galleryRepo;


//    public Review createReview(String title, String description, Rating rating, Integer profileId, Integer productId, Integer galleryId) {
//        Profile profile = profileRepo.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found with id: " + profileId));
//        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
//        Gallery gallery = galleryRepo.findById(galleryId).orElseThrow(() -> new RuntimeException("Gallery not found with id: " + galleryId));
//
//        Review review = new Review();
//        review.setTitle(title);
//        review.setDescription(description);
//        review.setRating(rating);
//        review.setProfile(profile);
//        review.setProduct(product);
//        review.setGallery(gallery);
//
//        return reviewRepo.save(review);
//    }

    @Transactional
    public Review createReview(CreateReviewDTO createReviewDTO) {
        Profile profile = profileRepo.findById(createReviewDTO.getProfileId())
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + createReviewDTO.getProfileId()));
        Product product = productRepo.findById(createReviewDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + createReviewDTO.getProductId()));

        Review review = new Review();
        review.setTitle(createReviewDTO.getTitle());
        review.setDescription(createReviewDTO.getDescription());
        review.setRating(createReviewDTO.getRating());
        review.setProfile(profile);
        review.setProduct(product);


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

    public List<Review> getAllReview()
    {
        return reviewRepo.findAll();
    }



}
