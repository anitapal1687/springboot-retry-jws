package com.anita.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anita.dto.UserDTO;
import com.anita.entity.UserEntity;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Integer> {
	
	UserEntity findByUsername(String username);
	UserEntity save( UserDTO dto);
	
}