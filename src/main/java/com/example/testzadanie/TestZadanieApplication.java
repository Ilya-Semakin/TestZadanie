package com.example.testzadanie;

import com.example.demo.tables.pojos.Employee;
import com.example.testzadanie.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SpringBootApplication
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class TestZadanieApplication {

	private final EmployeeService employeeService;

	@PostMapping
	public String addEmployee(@RequestBody Employee employee){
		employeeService.insertEmployee(employee);
		return "employee add";
	}
	@GetMapping
	public List<Employee> getEmployee(){
		return  employeeService.getEmployee();
	}


	public static void main(String[] args) {
		SpringApplication.run(TestZadanieApplication.class, args);
	}

}
