package com.itwins.artisanatshop.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itwins.artisanatshop.models.User;
import com.itwins.artisanatshop.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// ! @route GET /user?search=salah
	// ! @desc returns all users, and search by email if search param provided
	// ! @access public
	@CrossOrigin()
	@GetMapping("/user")
	public List<User> index(@RequestParam(value = "search", required = false) String searchText) {
		if (searchText == null) {
			return userService.findAll();
		}
		return userService.findBySearch(searchText);

	}

	@CrossOrigin()
	@GetMapping("/user/{id}")
	public Optional<User> userById(@PathVariable String id) {
		int userId = Integer.parseInt(id);
		return userService.findById(userId);
	}

	// ! @route POST /user
	// ! @desc create a new user in database. Body parameters needed :
	// email, firstname, lastname, age, password, role
	// ! @access public
	@CrossOrigin()
	@PostMapping("/user")
	public String create(@RequestBody Map<String, Object> userMap) {
		System.out.println(userMap);
		User user = new User(userMap);
		userService.saveUser(user);
		return "Utilisateur ajouté";

	}

	// ! @route PUT /user/id
	// ! @desc modifies user in database. Body parameters needed :
	// email, firstname, lastname, age, password, role
	// ! @access public
	@CrossOrigin()
	@PutMapping("/user/{id}")
	public User update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int userId = Integer.parseInt(id);
		Optional<User> user = userService.findById(userId);
		if (user.isPresent()) {
			User u = user.get();
			u.setEmail(body.get("email"));
			u.setFirstName(body.get("firstName"));
			u.setLastName(body.get("lastName"));
			u.setPassword(body.get("password"));
			u.setBirthDate(body.get("birthDate"));
			u.setUrl(body.get("url"));
			u.setRole(body.get("role"));
			return userService.saveUser(u);
		}
		return null;
	}

	// ! @route DELETE /user/id
	// ! @desc deletes user with param id
	// ! @access public
	@CrossOrigin()
	@DeleteMapping("user/{id}")
	public boolean delete(@PathVariable String id) {
		int userId = Integer.parseInt(id);
		return userService.deleteById(userId);
	}

	@CrossOrigin()
	@PostMapping("/signIn")
	public User signIn(@RequestBody Map<String, Object> userInfo) {
		Optional<User> user = userService.findUserByEmailAndPassword(userInfo.get("email").toString(),
				userInfo.get("password").toString());
		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}

}
