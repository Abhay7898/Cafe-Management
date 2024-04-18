package com.cafe.servicesimpl;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.model.SignUp;
import com.cafe.repositry.SignUpRepositry;
import com.cafe.services.SignUpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	public SignUpRepositry signUpRepositry;

	// private BCryptPasswordEncoder bCryptPasswordEncoder = new
	// BCryptPasswordEncoder();

	@Override
	public SignUp createUser(SignUp singUp) {
		List<SignUp> list=null;
		try {
			list= signUpRepositry.findUserByUserName(singUp.getUserName());	
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return list==null||list.isEmpty() ? signUpRepositry.save(singUp) : null;
	}

	@Override
	public SignUp loginUser(String userName, String password) {
		List<SignUp> list = signUpRepositry.findUserByUserName(userName);
		return list == null || list.isEmpty() ? null
				: signUpRepositry.findUserByUserNameAndPassword(userName, password);
		/*
		 * if(list == null || list.isEmpty()) { return null; }else {
		 * 
		 * boolean result = bCryptPasswordEncoder.matches(password,
		 * list.get(0).getPassword()); return result == true ? list.get(0) : null; }
		 */
	}

	@Override
	public List<SignUp> getAllUser() {
		return signUpRepositry.findAll();
	}

	@Override
	public SignUp getUserById(int id) {
		try {
			return signUpRepositry.findById(id).get();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateUser(SignUp signUp) {
		Optional<SignUp> check = signUpRepositry.findById(signUp.getId());
		if (check.isPresent()) {
			SignUp old = check.get();
			old.setId(signUp.getId());
			old.setUserName(signUp.getUserName());
			old.setPassword(signUp.getPassword());
			old.setFirstName(signUp.getFirstName());
			old.setLastName(signUp.getLastName());
			old.setAddress(signUp.getAddress());
			old.setCity(signUp.getCity());
			old.setEmailId(signUp.getEmailId());
			old.setMobileNumber(signUp.getMobileNumber());
			old.setImage(signUp.getImage());
			try {
				signUpRepositry.save(old);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUserById(int id) {
		if (signUpRepositry.existsById(id)) {
			try {
				signUpRepositry.deleteById(id);
				return true;
			} catch (Exception e) {
				log.error(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
