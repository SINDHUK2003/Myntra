package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {
}
