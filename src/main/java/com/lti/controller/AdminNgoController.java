package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Course;
import com.lti.entity.Ngo;
import com.lti.service.AdminNgoRepo;
import com.lti.service.AdminNgoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminngo")
public class AdminNgoController {

	@Autowired
	AdminNgoService adminNgoService;

	@GetMapping("/viewall")
	List<Ngo> getNgo() {
		return adminNgoService.getData();
	}

	@PutMapping("/update")
	public Ngo updateNgo(@RequestBody Ngo ngo) {
		return adminNgoService.updateNgo(ngo);
	}
}
