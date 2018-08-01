package com.xu.combootcomponnent.mapper;


import com.xu.combootcomponnent.entity.UserEntity;

import java.util.List;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}