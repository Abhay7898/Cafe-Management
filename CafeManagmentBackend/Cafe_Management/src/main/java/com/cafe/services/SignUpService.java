package com.cafe.services;

import java.util.List;

import com.cafe.model.Items;
import com.cafe.model.SignUp;

public interface SignUpService {

	public SignUp createUser(SignUp singUp);

	public SignUp loginUser(String userName, String password);

	public List<SignUp> getAllUser();

	public SignUp getUserById(int id);

	public boolean updateUser(SignUp signUp);

	public boolean deleteUserById(int id);

}
