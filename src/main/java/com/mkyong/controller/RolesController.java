package com.mkyong.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Roles;
import com.mkyong.service.RolesService;
@RestController
@RequestMapping("/api")
public class RolesController {	

	private RolesService rolesService;

	public RolesController(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@RequestMapping(value = "roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Roles> getAllRoles() {
		return rolesService.findAll();
	}
}
