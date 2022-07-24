package com.greatlearning.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;
import com.greatlearning.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.saveAndFlush(employee);

	}

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.getById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee oldEmp = employeeRepository.getById(employee.getId());
		BeanUtils.copyProperties(employee, oldEmp, "id");
		return employeeRepository.saveAndFlush(oldEmp);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getEmployeeByfirstName(String firstName) {
		// TODO Auto-generated method stub
		Employee sampleEmp = new Employee();
		sampleEmp.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("lastName", "id", "email");
		Example<Employee> example = Example.of(sampleEmp, exampleMatcher);
		return employeeRepository.findAll(example);

	}

	@Override
	public List<Employee> getEmployeeSorted(Direction direction) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
