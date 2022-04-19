package com.example.testzadanie;

import com.example.demo.tables.pojos.Employee;
import com.example.demo.tables.pojos.Task;
import com.example.testzadanie.service.EmployeeService;
import com.example.testzadanie.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SpringBootApplication
@RequestMapping("/employee")
@RequiredArgsConstructor
public class TestZadanieApplication {

	private final EmployeeService employeeService;
	private final TaskService taskService;

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee){
		employeeService.insertEmployee(employee);
		return "employee add";
	}
	@GetMapping
	public List<Employee> getEmployee(){
		return  employeeService.getEmployee();
	}


	@PostMapping("/task")
	public String addTask(@RequestBody Task task){
		taskService.insertTask(task);
		return "task add";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestZadanieApplication.class, args);
	}

}
