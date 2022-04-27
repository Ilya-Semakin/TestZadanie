package com.example.testzadanie.service;

import com.example.demo.Tables;
import com.example.demo.tables.pojos.Employee;
import com.example.demo.tables.records.EmployeeRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Name;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final DSLContext dslContext;




	public Employee	createEmployee(Employee employee){
		EmployeeRecord employeeRecord =dslContext.insertInto(Tables.EMPLOYEE)
				.set(Tables.EMPLOYEE.FULLNAME, employee.getFullname())
				.set(Tables.EMPLOYEE.LEADER, employee.getLeader())
				.set(Tables.EMPLOYEE.BRANCH,employee.getBranch())
				.returning(Tables.EMPLOYEE.ID)
				.fetchOne();
		employee.setId(employeeRecord.getId());
		return employee;
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



/*	public Long insert(Employee employee){
		return dslContext.insertInto(Tables.EMPLOYEE)
				.set(dslContext.newRecord(Tables.EMPLOYEE,employee))
				.returning(Tables.EMPLOYEE.ID)
				.fetchOptional()
				.orElseThrow(() -> new DataAccessException("error inserting:" + Tables.EMPLOYEE.ID))
				.get(Tables.EMPLOYEE.ID);
	}
*/
}

