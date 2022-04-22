package com.example.testzadanie.service;

import com.example.demo.Tables;
import com.example.demo.tables.pojos.Employee;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final DSLContext dslContext;

	public void insertEmployee(Employee employee){
		dslContext.insertInto(Tables.EMPLOYEE,Tables.EMPLOYEE.ID,Tables.EMPLOYEE.FULLNAME,
				Tables.EMPLOYEE.LEADER,Tables.EMPLOYEE.BRANCH)
				.values(employee.getId(),employee.getFullname(),
						employee.getLeader(),employee.getBranch())
				.execute();
	}

	public List<Employee> getEmployee(){
		return dslContext.selectFrom(Tables.EMPLOYEE)
				.fetchInto(Employee.class);
	}

	public Boolean delete(Long id){
		return dslContext.deleteFrom(Tables.EMPLOYEE)
				.where(Tables.EMPLOYEE.ID.eq(id))
				.execute()==1;
	}


}
