package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Role;

public interface RoleService {

	public void addRole(Role role);

	public List<Role> getRoles();

}
