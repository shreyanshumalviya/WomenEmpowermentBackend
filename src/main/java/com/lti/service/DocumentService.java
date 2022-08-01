package com.lti.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

public interface DocumentService {
	boolean loadFile(String fileName, HttpServletRequest request);
}
