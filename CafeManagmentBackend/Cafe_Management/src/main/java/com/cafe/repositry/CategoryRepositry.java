package com.cafe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cafe.model.Category;

public interface CategoryRepositry extends JpaRepository<Category, Integer>{
	Category getCategoryByType(String name);
}
