package com.itwins.artisanatshop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itwins.artisanatshop.models.User;
import com.itwins.artisanatshop.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findAll() {
		return  userRepository.findAll();
	}

	public boolean deleteById(int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	

	public List<User> findBySearch(String searchText) {
		return userRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
	}

}
