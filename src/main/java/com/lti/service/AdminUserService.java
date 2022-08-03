package com.lti.service;

import com.lti.dto.UserProfileDto;

public interface AdminUserService {
	UserProfileDto updateUser(UserProfileDto dto, Integer userId);
}
