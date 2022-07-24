package com.greatlearning.employee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.repository.RoleRepository;
import java.util.List;
import com.greatlearning.employee.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub

		roleRepository.saveAndFlush(role);
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
