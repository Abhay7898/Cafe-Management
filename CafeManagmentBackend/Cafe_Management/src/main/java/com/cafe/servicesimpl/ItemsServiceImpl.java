package com.cafe.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.Items;
import com.cafe.repositry.ItemRepositry;
import com.cafe.services.ItemsSevice;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemsServiceImpl implements ItemsSevice {

	@Autowired
	public ItemRepositry itemRepositry;

	@Override
	public Items createItems(Items items) {
		List<Items> list = itemRepositry.findItemsByName(items.getName());
		return list.isEmpty() ? itemRepositry.save(items) : null;
	}

	@Override
	public List<Items> getAllItems() {
		return itemRepositry.findAll();
	}

	@Override
	public List<Items> getAllItemsByCategory(int categoryId) {
		return itemRepositry.findItemsByCategoryId(categoryId);
	}

	@Override
	public Items getItemsById(int id) {
		try {
			return itemRepositry.findById(id).get();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateItems(Items items) {
		Optional<Items> check = itemRepositry.findById(items.getId());
		if (check.isPresent()) {
			Items oldItems = check.get();
			oldItems.setId(items.getId());
			oldItems.setName(items.getName());
			oldItems.setPrice(items.getPrice());
			oldItems.setDescription(items.getDescription());
			oldItems.setImage(items.getImage());
			oldItems.setCategoryId(items.getCategoryId());
			try {
				itemRepositry.save(oldItems);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteItemsById(int id) {
		if (itemRepositry.existsById(id)) {
			try {
				itemRepositry.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

}
