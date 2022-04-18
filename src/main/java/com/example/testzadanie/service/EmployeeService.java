package com.example.testzadanie.service;

import com.example.demo.Tables;
import com.example.demo.tables.pojos.Employee;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	private DSLContext dslContext;

	public void insertEmployee(Employee employee){
		dslContext.insertInto(Tables.EMPLOYEE,Tables.EMPLOYEE.ID,Tables.EMPLOYEE.FULLNAME,
				Tables.EMPLOYEE.LEADER,Tables.EMPLOYEE.BRANCH)
				.values(employee.getId(),employee.getFullname(),
						employee.getLeader(),employee.getLeader())
				.execute();
	}

	public List<Employee> getEmployee(){
		return dslContext.selectFrom(Tables.EMPLOYEE)
				.fetchInto(Employee.class);
	}

}
