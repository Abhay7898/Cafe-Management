package com.cafe.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.model.Items;

public interface ItemRepositry extends JpaRepository<Items,Integer>{
	
	List<Items> findItemsByName(String name);
	
	List<Items> findItemsByCategoryId(int categoryId);
}
