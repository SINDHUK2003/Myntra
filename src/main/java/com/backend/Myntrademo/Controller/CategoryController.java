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

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category)
    {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/deleteCategory/{categoryid}")
    public String deleteCategory(@PathVariable("categoryid") int categoryid)
    {
        categoryService.deleteCategory(categoryid);
        return "Category deleted !";
    }

    @GetMapping("/getCategory/{categoryid}")
    public Category getCategory(@PathVariable("categoryid") int categoryid)
    {
        return categoryService.getCategory(categoryid);
    }

    @PostMapping("/addSubcategory/{maincategory}")
    public Category addSubcategory(@PathVariable("maincategory") String maincategory, @RequestBody Map<String, String> requestBody) {
        String subcategory = requestBody.get("subcategory");
        return categoryService.addSubcategory(maincategory, subcategory);
    }

    @DeleteMapping("/deleteSubcategory/{maincategory}")
    public Category deleteSubcategory(@PathVariable("maincategory") String maincategory, @RequestBody Map<String, String> requestBody) {
        String subcategory = requestBody.get("subcategory");
        Category category = categoryService.getCategoryByMaincategory(maincategory);
        if (category != null) {
            return categoryService.deleteSubcategory(category, subcategory);
        } else {
            throw new RuntimeException("Main category not found: " + maincategory);
        }
    }




}
