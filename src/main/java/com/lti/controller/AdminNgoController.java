package com.lti.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoDocDto;
import com.lti.dto.NgoDocRegister;
import com.lti.dto.UserIdDto;
import com.lti.dto.UserProfileDto;
import com.lti.entity.Accomodation;
import com.lti.entity.Ngo;
import com.lti.entity.NgoDocuments;
import com.lti.service.AdminNgoServiceImpl;
import com.lti.service.DocumentService;
import com.lti.service.NgoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminngo")
public class AdminNgoController {

	@Autowired
	DocumentService docService;

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

	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public String loadFile(@RequestBody String fileName, HttpServletRequest request) {
		return docService.loadFile(fileName, request);
	}

	@RequestMapping(value = "/viewNgoDoc/{ngoId}", method = RequestMethod.GET)
	public NgoDocDto getNgoDoc(@PathVariable int ngoId) {
		NgoDocuments doc = ngoService.getNgoDocument(ngoId);
		NgoDocDto ngoDocDto = new NgoDocDto();
		ngoDocDto.setCertificateNo(doc.getCertificateNo());
		ngoDocDto.setCertificateLink(doc.getCertificateLink());
		return ngoDocDto;
	}
}
