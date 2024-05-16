package com.bytes.errs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.errs.dao.CategoryRepository;
import com.bytes.errs.model.Category;
import com.bytes.errs.service.CategoryService;

@Service
public class CategoryServeImpl implements CategoryService{
	
	@Autowired
	public CategoryRepository categoryRepository;

	@Override
	public Category addNewReward(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

}
