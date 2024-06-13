package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Service.CategoryService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory/{profileId}")
    public Category createCategory(@PathVariable("profileId") int profileId, @RequestBody Category category) {
        return categoryService.createCategory(profileId, category);
    }

    @DeleteMapping("/deleteCategory/{profileId}/{categoryid}")
    public String deleteCategory(@PathVariable("profileId") int profileId, @PathVariable("categoryid") int categoryid) {
        categoryService.deleteCategory(profileId, categoryid);
        return "Category deleted!";
    }

    @GetMapping("/getCategory/{categoryid}")
    public Category getCategory(@PathVariable("categoryid") int categoryid)
    {
        return categoryService.getCategory(categoryid);
    }

    @PostMapping("/addSubcategory/{profileId}/{maincategory}")
    public Category addSubcategory(@PathVariable("profileId") int profileId, @PathVariable("maincategory") String maincategory, @RequestBody Map<String, String> requestBody) {
        String subcategory = requestBody.get("subcategory");
        return categoryService.addSubcategory(profileId, maincategory, subcategory);
    }

    @DeleteMapping("/deleteSubcategory/{profileId}/{maincategory}")
    public Category deleteSubcategory(@PathVariable("profileId") int profileId, @PathVariable("maincategory") String maincategory, @RequestBody Map<String, String> requestBody) {
        String subcategory = requestBody.get("subcategory");
        Category category = categoryService.getCategoryByMaincategory(maincategory);
        if (category != null) {
            return categoryService.deleteSubcategory(profileId, category, subcategory);
        }
        else
        {
            throw new RuntimeException("Main category not found: " + maincategory);
        }
    }




}