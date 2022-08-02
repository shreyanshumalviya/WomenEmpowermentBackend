package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.SukanyaAccount;
import com.lti.service.AdminSukanyaServiece;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminsukanya")
public class AdminSukanyaController {

	@Autowired
	AdminSukanyaServiece adminSukanyaService;

	@GetMapping("/viewall")
	List<SukanyaAccount> getNgo() {
		return adminSukanyaService.getData();
	}
}
