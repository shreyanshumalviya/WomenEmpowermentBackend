package com.lti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.UserProfileDto;
import com.lti.entity.User;
import com.lti.exception.ResourseNotFoundException;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	private AdminUserRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public List<User> getData() {
		return (List<User>) repo.findAll();
	}

	@Override
	public UserProfileDto updateUser(UserProfileDto dto, Integer userId) {
		User user = this.repo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", "id", userId));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setVerified(dto.isVerified());
		User updatedUser = this.repo.save(user);
		UserProfileDto dto1 = this.UserTodto(updatedUser);
		return dto1;
	}

	public User dtoToUser(UserProfileDto dto) {
		User user = this.modelMapper.map(dto, User.class);
		return user;
	}

	public UserProfileDto UserTodto(User user) {
		UserProfileDto userdto = this.modelMapper.map(user, UserProfileDto.class);
		return userdto;
	}

}
