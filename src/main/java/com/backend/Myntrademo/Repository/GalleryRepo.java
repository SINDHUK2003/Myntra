package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryRepo extends JpaRepository<Gallery, Integer> {
    List<Gallery> findByType(String type);
}
