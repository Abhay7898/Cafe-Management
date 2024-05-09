package com.cafe.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cafe.model.Category;
import com.cafe.servicesimpl.CategoryServiceImpl;
import com.cafe.utils.Massage;
import com.cafe.utils.Response;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class CategoryController {

	@Autowired
	public CategoryServiceImpl categoryServiceImpl;

	@PostMapping(path = "/createCategory")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		log.info("Create Category API Call");
		Response r = new Response();
		r.setKey("Msg");
		Category check = categoryServiceImpl.createCategory(category);
		if (check != null) {
			return new ResponseEntity<>(check, HttpStatus.OK);
		}
		r.setMsg(Massage.CATEGORY_ALLREADY_EXSITS);
		return new ResponseEntity<>(r, HttpStatus.CONFLICT);
	}

	@GetMapping(path = "/getAllCategories")
	public ResponseEntity<?> getAllCategories() {
		log.info("Get All Categories API Call");
		List<Category> list = categoryServiceImpl.getAllCategories();
		return list == null || list.isEmpty() ? new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/getCategoryById/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id) {
		log.info("Get Category By Id API Call");
		Category check = categoryServiceImpl.getCategoryById(id);
		return check != null ? new ResponseEntity<>(check, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/updateCategory")
	public ResponseEntity<?> updateCategoryById(@RequestBody Category category) {
		log.info("Update Category API Call");
		boolean check = categoryServiceImpl.updateCategory(category);
		return check ? new ResponseEntity<>(Massage.DATA_UPDATED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "/deleteCategory/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable int id) {
		log.info("Delete Category API Call");
		boolean check = categoryServiceImpl.deleteCategoryById(id);
		return check ? new ResponseEntity<>(Massage.DATA_DELETED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}
}
