package com.virtualClass.App.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.virtualClass.App.model.Student;
import com.virtualClass.App.model.User;
import com.virtualClass.App.service.UserService;


@RestController
@CrossOrigin
public class UserCotnroller {

	@Autowired
	private UserService userService;

	
	
	
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {

		try {
			user = userService.saveOrUpdateUser(user);
			if (user.isMessageStatus()) {
				user.setMessage("Save Successfully");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			user.setMessage(ex.getMessage());
			user.setMessageStatus(false);

		}

		return user;
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {

		try {
			user = userService.saveOrUpdateUser(user);
			if (user.isMessageStatus()) {
				user.setMessage("Update Successfully");
			}

		} catch (Exception ex) {
			ex.printStackTrace();

			user.setMessage(ex.getMessage());
			user.setMessageStatus(false);

		}

		return user;
	}

	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable String userId) {

		User user;
		try {
			user = userService.getUser(userId);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			user = new User();
			user.setMessage(e.getMessage());
			user.setMessageStatus(false);
		}

		return user;

	}

	@GetMapping("/getUsers")
	public Iterable<User> getUsers() {

		Iterable<User> users;
		try {
			users = userService.getUsers();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			users = null;
		}

		return users;

	}

	@PostMapping("/login")
	public User Login(@RequestBody User user) {

		try {
			user = userService.loginUser(user.getUserid().trim(), user.getPassword().trim());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			user.setMessage(e.getMessage());
			user.setMessageStatus(false);
		}

		return user;
	}



}
