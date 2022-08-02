package com.lti.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public interface AdminUserRepo extends JpaRepository<User, Integer> {
}
