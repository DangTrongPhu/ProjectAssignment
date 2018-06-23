package com.mkyong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.model.Roles;
import com.mkyong.repository.RolesRepository;

@Service
public class RolesService {

	private RolesRepository rolesRepository;

	@Autowired
	public RolesService(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
	
	public List<Roles> findAll() {
		return rolesRepository.findAll();
	}
}
