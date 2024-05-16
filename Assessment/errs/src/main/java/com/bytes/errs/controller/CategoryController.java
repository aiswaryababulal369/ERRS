package com.bytes.errs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.errs.model.Category;
import com.bytes.errs.service.CategoryService;

@RestController
@RequestMapping(value = "category")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	public CategoryService  categoryService;
	
	@PostMapping("/addNewCategory")
	public Category addNewCategory(@RequestBody Category category) {
		return categoryService.addNewReward(category);
		
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(){
		return categoryService.getAllCategory();
		
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
