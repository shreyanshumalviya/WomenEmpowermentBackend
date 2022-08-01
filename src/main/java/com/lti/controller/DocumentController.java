package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FileDTO;
import com.lti.entity.User;
import com.lti.service.DocumentService;
import com.lti.service.DocumentServiceImpl;

@RestController
@RequestMapping("/document")
@CrossOrigin(origins = "*")
public class DocumentController {
	@Autowired
	DocumentServiceImpl documentService;
	
	@PostMapping("/upload")
	public String upload(FileDTO fileDto, HttpServletRequest request) {
		String imageUploadLocation = "D://uploads/";
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString()+fileDto.getFile().getOriginalFilename()+".jpg";// fileDto.getFile().getOriginalFilename();
		
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(fileDto.getFile().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			return "File not uploaded \n"+e.getMessage();
		}
//		documentService.loadFile(fileName, request);
		return fileName;
	}
	
	
}
