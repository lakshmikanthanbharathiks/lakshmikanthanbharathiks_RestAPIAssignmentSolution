package com.greatlearning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}

	@GetMapping("/list")
	public List<Employee> listEmployee() {
		return employeeService.listEmployee();

	}

	@GetMapping("/find/{id}")
	public Employee findEmployeeByID(@PathVariable int id) {
		return employeeService.findEmployeeByID(id);
	}

	@PostMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Deleted Employee id - " + id;
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> getEmployeeByfirstName(@PathVariable String firstName) {
		return employeeService.getEmployeeByfirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeeSorted(Direction direction) {
		return employeeService.getEmployeeSorted(direction);
	}
}
