package com.cafe.services;

import java.util.List;

import com.cafe.model.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategoryById(int id);
	
}
