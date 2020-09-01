package com.ilkert.issuemanagement.service.Impl;

import com.ilkert.issuemanagement.entity.User;
import com.ilkert.issuemanagement.repository.UserRepository;
import com.ilkert.issuemanagement.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User Save(User user) {

		if (null == user.getEmail()) {

			throw new IllegalArgumentException("User E mail address can not be null !");
		}

		user = userRepository.save(user);
		
		return user;
	}

	@Override
	public User getById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public Page<User> getAllPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User getByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
