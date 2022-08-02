package com.lti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.exception.*;
import com.lti.dto.NgoRegisterDto;
import com.lti.entity.Ngo;

@Service
public class AdminNgoServiceImpl implements AdminNgoService {
	@Autowired
	private AdminRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public List<Ngo> getData() {
		return (List<Ngo>) repo.findAll();
	}

	@Override
	public NgoRegisterDto updateNgo(NgoRegisterDto dto, Integer ngoId) {
		Ngo ngo = this.repo.findById(ngoId).orElseThrow(() -> new ResourseNotFoundException("Ngo", "id", ngoId));
		ngo.setName(dto.getName());
		ngo.setVerified(dto.isVerified());
		Ngo updatedNgo = this.repo.save(ngo);
		NgoRegisterDto dto1 = this.NgoTodto(updatedNgo);
		return dto1;
	}


	public Ngo dtoToNgo(NgoRegisterDto dto) {
		Ngo ngo = this.modelMapper.map(dto, Ngo.class);
		return ngo;
	}

	public NgoRegisterDto NgoTodto(Ngo ngo) {
		NgoRegisterDto ngodto = this.modelMapper.map(ngo, NgoRegisterDto.class);
		return ngodto;
	}

}
