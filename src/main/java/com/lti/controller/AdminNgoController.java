package com.lti.controller;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoRegisterDto;
import com.lti.entity.Course;
import com.lti.entity.Ngo;
import com.lti.service.AdminNgoServiceImpl;
import com.lti.service.AdminRepo;
import com.lti.service.NgoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminngo")
public class AdminNgoController {

	@Autowired
	private AdminNgoServiceImpl adminNgoService;
	
	@Autowired
	NgoService ngoService;

	@GetMapping("/viewall")
	List<Ngo> getNgo() {
		return adminNgoService.getData();
	}

//	@PutMapping("/update/{ngoId}")
//	public ResponseEntity<NgoRegisterDto> updateNgo(@RequestBody NgoRegisterDto Dto, @PathVariable Integer ngoId ) {
//		NgoRegisterDto updatedNgo=this.adminNgoService.updateNgo(Dto, ngoId);
//		return ResponseEntity.ok(updatedNgo);
//	}
	
	@PutMapping("/verify/{ngoId}")
	public boolean verifyNgo(@PathVariable int ngoId) {
		return ngoService.verifyNgo(ngoId);
	}
}
