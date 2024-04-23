package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>
{
    Category findByMaincategory(String maincategory);
}
