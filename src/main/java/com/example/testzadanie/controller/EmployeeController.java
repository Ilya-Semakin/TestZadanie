package com.example.testzadanie.controller;


import com.example.demo.tables.pojos.Employee;
import com.example.testzadanie.repository.impl.EmployeeRepository;
import com.example.testzadanie.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final EmployeeRepository employeeRepository;

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return 	employeeService.createEmployee(employee);
	}

	@GetMapping("/add")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/all/{id}")
	public void delEmployee(@PathVariable String id){
		employeeRepository.delete(Long.parseLong(id));
	}
}