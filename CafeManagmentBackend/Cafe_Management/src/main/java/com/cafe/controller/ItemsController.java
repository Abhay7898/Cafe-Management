package com.cafe.controller;

import java.util.Base64;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cafe.model.Items;
import com.cafe.servicesimpl.ItemsServiceImpl;
import com.cafe.utils.Massage;
import com.cafe.utils.Response;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class ItemsController {

	@Autowired
	public ItemsServiceImpl itemsServiceImpl;

	@PostMapping(path = "/createItems")
	public ResponseEntity<?> createItems(@RequestBody Items items) {
		log.info("Create API Call");
		Response r = new Response();
		r.setKey("Msg");
		Items check = itemsServiceImpl.createItems(items);
		if (check != null) {
			r.setMsg(Massage.SUCCESSFUL);
			return new ResponseEntity<>(r, HttpStatus.OK);
		}
		r.setMsg(Massage.ITEMS_ALREADY_EXISTS);
		return new ResponseEntity<>(r, HttpStatus.IM_USED);
	}

	@GetMapping(path = "/getAllItems")
	public ResponseEntity<?> getAllItems() {
		log.info("Get All Items API Call");
		List<Items> check = itemsServiceImpl.getAllItems();
		check = check.stream().sorted(Comparator.comparingInt(Items :: getId)).collect(Collectors.toList());;
		int i = 0;
		for(Items it : check) {
			it.setId(i);
			i++;
		}
		return check.isEmpty() ? new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(check, HttpStatus.OK);
	}

	@GetMapping(path = "getAllItemsByCategory/{categoryId}")
	public ResponseEntity<?> getAllItemsByCategory(@PathVariable int categoryId) {
		log.info("Get All Items Api Call");
		List<Items> check = itemsServiceImpl.getAllItemsByCategory(categoryId);
		return check.isEmpty() ? new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(check, HttpStatus.OK);
	}

	@GetMapping(path = "/getItemsById/{id}")
	public ResponseEntity<?> getItemsById(@PathVariable int id) {
		log.info("Get Items By Id API Call");
		Items check = itemsServiceImpl.getItemsById(id);
		return check != null ? new ResponseEntity<>(check, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/updateItems")
	public ResponseEntity<?> updateItems(@RequestBody Items items) {
		log.info("Update Itmes API Call");
		boolean check = itemsServiceImpl.updateItems(items);
		return check ? new ResponseEntity<>(Massage.DATA_UPDATED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "/deleteItemsById/{id}")
	public ResponseEntity<?> deleteItemsById(@PathVariable int id) {
		log.info("Delete Items API Call");
		boolean check = itemsServiceImpl.deleteItemsById(id);
		return check ? new ResponseEntity<>(Massage.DATA_DELETED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(path = "/imageUploaded/{id}")
	public void imageUploaded(@PathVariable ("id")int id,@RequestParam ("file")MultipartFile file) {
		Items items = itemsServiceImpl.getItemsById(id);
		try {
			items.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		itemsServiceImpl.updateItems(items);
		
	}
}
