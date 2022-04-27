package com.example.testzadanie;

import com.example.demo.Tables;
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


@SpringBootApplication
public class TestZadanieApplication {


	public static void main(String[] args) {
		SpringApplication.run(TestZadanieApplication.class, args);
	}

}

