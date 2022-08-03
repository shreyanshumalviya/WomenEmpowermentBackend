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
import com.lti.dto.SukanyaDocDto;
import com.lti.entity.NgoDocuments;
import com.lti.entity.SukanyaAccount;
import com.lti.entity.SukanyaDoc;
import com.lti.service.AdminSukanyaServiece;
import com.lti.service.DocumentService;
import com.lti.service.SukanyaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminsukanya")
public class AdminSukanyaController {

	@Autowired
	AdminSukanyaServiece adminSukanyaService;

	@Autowired
	DocumentService docService;

	@Autowired
	SukanyaService sukanyaService;

	@GetMapping("/viewall")
	List<SukanyaAccount> getNgo() {
		List<SukanyaAccount> accounts=  adminSukanyaService.getData();
		for(SukanyaAccount account :accounts) {
			account.setUser(null);
			if(account.getSukanyaDoc()!=null)
			    account.getSukanyaDoc().setSukanyaAccount(null);
		} 
		return accounts;
	}

	@PutMapping("/verify/{accountId}")
	public boolean verifyUser(@PathVariable int accountId) {
		return sukanyaService.verifySukanya(accountId);
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public String loadFile(@RequestBody String fileName, HttpServletRequest request) {
		return docService.loadFile(fileName, request);
	}

	@RequestMapping(value = "/viewSukanyaDoc/{accountId}", method = RequestMethod.GET)
	public SukanyaDocDto getSukanyaDoc(@PathVariable int accountId) {
		SukanyaDoc doc = sukanyaService.getSukanyaDocument(accountId);
		SukanyaDocDto sukanyaDocDto = new SukanyaDocDto();
		sukanyaDocDto.setAadhaarLink(doc.getAadhaarLink());
		sukanyaDocDto.setAadhaarNo(doc.getAadhaarNo());
		return sukanyaDocDto;
	}
}
