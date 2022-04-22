package com.example.testzadanie.controller;


import com.example.demo.tables.pojos.Employee;
import com.example.testzadanie.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor

public class EmployeeController {

private final EmployeeService employeeService;


		@PostMapping("/add")
		public String addEmployee(@RequestBody Employee employee){
			employeeService.insertEmployee(employee);
			return "employee add";
		}
		@GetMapping("/all")
		public List<Employee> getEmployee(){
			return  employeeService.getEmployee();
		}

		@DeleteMapping("/all/{id}")
		public String del(@PathVariable Employee employee){
			employeeService.delete(employee.getId());

			return "ydaleno";
		}
}
