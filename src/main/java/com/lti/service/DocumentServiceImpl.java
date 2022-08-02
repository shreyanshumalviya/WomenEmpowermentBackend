package com.lti.service;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Override
	public String loadFile(String fileName, HttpServletRequest request) {
		String projPath = request.getServletContext().getRealPath("/");
		String tempDownloadPath = projPath + "downloads/";
		// creating a folder within the project where we will place the profile pic of
		// the customer getting fetched
		File f = new File(tempDownloadPath);
		if (!f.exists())
			f.mkdir();
		String targetFile = tempDownloadPath + fileName;
		System.out.println(targetFile);

		// the original location where the uploaded images are present
		String uploadedImagesPath = "d:/uploads/";
		String sourceFile = uploadedImagesPath + fileName;

		try {
			FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			// maybe for this customer there is no profile pic
			return null;
		}

		return "http://localhost:9090/downloads/" + fileName;
	}

}
