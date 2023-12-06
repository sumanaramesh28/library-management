package com.course.librarymanagement.controller;


import com.course.librarymanagement.entity.Category;
import com.course.librarymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String removeCategoryById(@PathVariable Long id, Model model) {
        categoryService.removeCategoryById(id);
        model.addAttribute("categories",categoryService.findAllCategories());
        return "categories";
    }


    @GetMapping("/add-category")
    public String createCategory(Category category, Model model) {
        model.addAttribute("categories",categoryService.findAllCategories());
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory( Category category,BindingResult result,Model model) {
        if (result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories",categoryService.findAllCategories());
        return "redirect:/categories";
    }


    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id,Model model) {
        Category category= categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "update-category";
    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category,  BindingResult result,Model model) {
        if (result.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("category",categoryService.findAllCategories());
        return "redirect:/categories";
    }



}
