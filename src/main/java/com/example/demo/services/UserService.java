package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;

		// spring does not handle the BCryptPasswordEncoder object we have to create
		// it.i have created in package
		this.passwordEncoder = passwordEncoder;
	}

	public User userRegister(User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {

			// throw exception
			throw new RuntimeException("User name is already taken");
		}

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			// thow excetion
			throw new RuntimeException("Email is already registered");
		}

//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		String planepwd = user.getPassword();
		String enpwd = passwordEncoder.encode(planepwd);
		user.setPassword(enpwd);
		return userRepository.save(user);

	}

}
