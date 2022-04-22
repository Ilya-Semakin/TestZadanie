package com.example.testzadanie.controller;

import com.example.demo.tables.pojos.Employee;
import com.example.demo.tables.pojos.Task;
import com.example.testzadanie.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {


	private final TaskService taskService;

	@PostMapping("/task")
	public String addTask(@RequestBody Task task){
		taskService.insertTask(task);
		return "task add";
	}
	@GetMapping("/all")
	public List<Task> getTask(){
		return  taskService.getTask();
	}

}
