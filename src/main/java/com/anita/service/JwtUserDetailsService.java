package com.anita.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anita.dao.UserDao;
import com.anita.dto.UserDTO;
import com.anita.entity.UserEntity;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + "not found");
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserEntity save(UserDTO user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
}