package com.cafe.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Category;
import com.cafe.repositry.CategoryRepositry;
import com.cafe.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepositry categoryRepositry;

	@Override
	public Category createCategory(Category category) {
		Category categoryType = categoryRepositry.getCategoryByType(category.getType());
		return categoryType == null ? categoryRepositry.save(category) : null;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepositry.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		try {
			return categoryRepositry.findById(id).get();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		Optional<Category> check = categoryRepositry.findById(category.getId());
		if (check.isPresent()) {
			Category old = check.get();
			old.setId(category.getId());
			old.setType(category.getType());
			old.setDescription(category.getDescription());
			try {
				categoryRepositry.save(old);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCategoryById(int id) {
		if (categoryRepositry.existsById(id)) {
			try {
				categoryRepositry.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
