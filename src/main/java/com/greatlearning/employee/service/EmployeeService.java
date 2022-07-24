package com.greatlearning.employee.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employee.entity.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> listEmployee();

	public Employee findEmployeeByID(int id);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployee(int id);

	public List<Employee> getEmployeeByfirstName(String firstName);

	public List<Employee> getEmployeeSorted(Direction direction);

}
