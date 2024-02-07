package com.cafe.services;

import java.util.List;

import com.cafe.model.Items;

public interface ItemsSevice {
	
	public Items createItems(Items items);
	
	public List<Items> getAllItems();
	
	public List<Items> getAllItemsByCategory(int categoryId);

	public Items getItemsById(int id);
	
	public boolean updateItems(Items items);
	
	public boolean deleteItemsById(int id);

}
