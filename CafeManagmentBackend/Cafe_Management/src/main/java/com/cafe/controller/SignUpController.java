package com.cafe.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.cafe.dto.SignUpDTO;
import com.cafe.model.SignUp;
import com.cafe.servicesimpl.SignUpServiceImpl;
import com.cafe.utils.Massage;
import com.cafe.utils.Response;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class SignUpController {

	@Autowired
	public SignUpServiceImpl signUpServiceImpl;

	/*
	 * @Autowired public BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@PostMapping("/creatUser")
	public ResponseEntity<?> createUser(@RequestBody SignUp signUp) {
		log.info("Create User API Call");

		SignUp result = signUpServiceImpl.createUser(signUp);

		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		Response r = new Response();
		r.setKey("Msg");
		r.setMsg(Massage.USER_NAME_ALREADY_EXIST);
		return new ResponseEntity<>(r, HttpStatus.CONFLICT);
		/*
		 * boolean password = CafeUtils.passwordMatch(signUp.getPassword(),
		 * signUp.getConfrimPassword()); if (password) {
		 * signUp.setPassword(this.bCryptPasswordEncoder.encode(signUp.getPassword()));
		 */
	}

	@GetMapping("/login")
	public ResponseEntity<?> loginByUserNameAndPassword(@Param("userName") String userName,
			@Param("password") String password) throws CloneNotSupportedException {
		log.info("Login API Call");
		// String enPassword = this.bCryptPasswordEncoder.encode(password);
		SignUp result = signUpServiceImpl.loginUser(userName, password);
		if (result != null) {
			SignUpDTO signUpDTO = (SignUpDTO) result.clone();
			return new ResponseEntity<>(signUpDTO, HttpStatus.OK);
		}
		Response r = new Response();
		r.setKey("Msg");
		r.setMsg(Massage.NOT_A_VALID_USER);
		return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/getAllUser")
	public ResponseEntity<?> getAllUser() {
		log.info("Get All User API Call");
		List<SignUp> list = signUpServiceImpl.getAllUser();
		return list.isEmpty() ? new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		log.info("Get User By Id API Call");
		SignUp check = signUpServiceImpl.getUserById(id);
		return check != null ? new ResponseEntity<>(check, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody SignUp signUp) {
		boolean check = signUpServiceImpl.updateUser(signUp);
		return check ? new ResponseEntity<>(Massage.DATA_UPDATED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id) {
		boolean check = signUpServiceImpl.deleteUserById(id);
		return check ? new ResponseEntity<>(Massage.DATA_DELETED_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(Massage.NO_DATA_FOUND, HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/imageUpload/{id}")
	public void imageUpload(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
		SignUp user = signUpServiceImpl.getUserById(id);
		try {
			user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		signUpServiceImpl.updateUser(user);
	}
}
