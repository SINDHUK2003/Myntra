package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(Category category)
    {
        return categoryRepo.save(category);
    }

    public void deleteCategory(int categoryid)
    {
        categoryRepo.deleteById(categoryid);
    }

    public Category getCategory(int categoryid)
    {
        Optional<Category> dispCategory = categoryRepo.findById(categoryid);
        return dispCategory.orElse(null);
    }

    public Category addSubcategory(String maincategory, String subcategory)
    {
        Category category = categoryRepo.findByMaincategory(maincategory);

        if (category != null)
        {
            if (category.getSubcategory1() == null || category.getSubcategory1().isEmpty())
            {
                category.setSubcategory1(subcategory);
            }
            else if (category.getSubcategory2() == null || category.getSubcategory2().isEmpty())
            {
                category.setSubcategory2(subcategory);
            }
            else if (category.getSubcategory3() == null || category.getSubcategory3().isEmpty())
            {
                category.setSubcategory3(subcategory);
            }
            else if (category.getSubcategory4() == null || category.getSubcategory4().isEmpty())
            {
                category.setSubcategory4(subcategory);
            }
            else if (category.getSubcategory5() == null || category.getSubcategory5().isEmpty())
            {
                category.setSubcategory5(subcategory);
            }
            else
            {
                throw new RuntimeException("All subcategory slots are filled for the main category: " + maincategory);
            }

            return categoryRepo.save(category);
        }
        else
        {
            throw new RuntimeException("Main category not found: " + maincategory);
        }
    }



}
