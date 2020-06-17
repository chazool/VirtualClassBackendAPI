package com.virtualClass.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.User;
import com.virtualClass.App.repository.UserRepository;

import java.util.Random;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveOrUpdateUser(User user) throws Exception {

		user.setMessageStatus(false);

		// Check User ID - NIC
		if (CommonLogic.isValidNic(user.getUserid()) == false) {
			user.setMessage("Invalid User Id");
		} else if (CommonLogic.isLengthZeroOrNull(user.getPassword().trim())) {
			user.setMessage("Invalid Password");
		} else if (user.getPassword().trim().length() <= 5) {
			user.setMessage("Password is Weak");
		} else if (isValidUserRole(user.getUserrole()) == false) {
			user.setMessage("Invalid User Role");
		}

		else {
			user.setIslogin(false);
			user = userRepository.save(user);
			user.setMessageStatus(true);
		}

		return user;

	}

	public User getUser(String userId) throws Exception {

		User user;

		if (CommonLogic.isValidNic(userId.trim())) {
			user = userRepository.findById(userId).get();
			user.setMessageStatus(true);
		} else {
			user = new User();
			user.setMessageStatus(false);
			user.setMessage("Invalid UserId");
		}
		return user;

	}

	public Iterable<User> getUsers() throws Exception {
		return userRepository.findAll();
	}

	public User loginUser(String userId, String Password) {

		User user = new User();
		user.setMessageStatus(false);

		if (CommonLogic.isValidNic(userId.trim()) == false || CommonLogic.isLengthZeroOrNull(userId.trim())) {

			user.setMessage("Invalid User Name");

		} else if (CommonLogic.isLengthZeroOrNull(Password.trim())) {
			user.setMessage("Password is Empty");
		} else {
			user = userRepository.findById(userId).get();
			// check login
			if (user.getUserid().equals(userId.trim()) && user.getPassword().equals(Password.trim())) {
				user.setMessageStatus(true);
				user.setMessage("Login Successfully");
				// Update Is Login Status--------------------------------

			} else {
				user.setMessage("Invalid Login Details");
				user.setMessageStatus(false);
			}
		}

		return user;
	}

	private static boolean isValidUserRole(String role) {

		boolean result = false;
		role = role.trim().toLowerCase();

		if (role.equals("student")) {
			result = true;
		} else if (role.equals("teacher")) {
			result = true;
		}

		return result;
	}

	
	 public  char[] getGeneratePassword() {
		 int length = 8;
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));

	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
	   }
	
	
}
