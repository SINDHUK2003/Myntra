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

    @Autowired
    private ProfileService profileService;


    //function done only by employee
    public Category createCategory(int profileId, Category category)
    {
        if (profileService.isEmployeeLoggedIn(profileId))
        {
            return categoryRepo.save(category);
        }
        else
        {
            throw new IllegalArgumentException("Only logged-in employees can create categories.");
        }
    }

    public void deleteCategory(int profileId, int categoryid)
    {
        if (profileService.isEmployeeLoggedIn(profileId))
        {
            categoryRepo.deleteById(categoryid);
        }
        else
        {
            throw new IllegalArgumentException("Only logged-in employees can delete categories.");
        }
    }

    public Category addSubcategory(int profileId, String maincategory, String subcategory)
    {
        if (profileService.isEmployeeLoggedIn(profileId)) {
            Category category = categoryRepo.findByMaincategory(maincategory);

            if (category != null) {
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
                else {
                    throw new RuntimeException("All subcategory slots are filled for the main category: " + maincategory);
                }

                return categoryRepo.save(category);
            }
            else
            {
                throw new RuntimeException("Main category not found: " + maincategory);
            }
        }
        else
        {
            throw new IllegalArgumentException("Only logged-in employees can add subcategories.");
        }
    }

    public Category deleteSubcategory(int profileId, Category category, String subcategory) {
        if (profileService.isEmployeeLoggedIn(profileId))
        {
            if (subcategory.equals(category.getSubcategory1()))
            {
                category.setSubcategory1(null);
            }
            else if (subcategory.equals(category.getSubcategory2()))
            {
                category.setSubcategory2(null);
            }
            else if (subcategory.equals(category.getSubcategory3()))
            {
                category.setSubcategory3(null);
            }

            else if (subcategory.equals(category.getSubcategory4()))
            {
                category.setSubcategory4(null);
            }
            else if (subcategory.equals(category.getSubcategory5()))
            {
                category.setSubcategory5(null);
            }

            return categoryRepo.save(category);
        }
        else
        {
            throw new IllegalArgumentException("Only logged-in employees can delete subcategories.");
        }
    }

    //function accessed byy any type of profile
    public Category getCategory(int categoryid)
    {
        Optional<Category> dispCategory = categoryRepo.findById(categoryid);
        return dispCategory.orElse(null);
    }
    public Category getCategoryByMaincategory(String maincategory)
    {
        return categoryRepo.findByMaincategory(maincategory);
    }

}