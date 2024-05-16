package com.bytes.errs.service;

import java.util.List;

import com.bytes.errs.model.Category;


public interface CategoryService {

	Category addNewReward(Category category);

	List<Category> getAllCategory();

	void deleteCategory(Long categoryId);

}
