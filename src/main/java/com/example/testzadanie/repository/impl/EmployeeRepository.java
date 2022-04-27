package com.example.testzadanie.repository.impl;

import com.example.demo.Tables;
import com.example.demo.tables.pojos.Employee;
import com.example.demo.tables.records.EmployeeRecord;
import com.example.testzadanie.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Condition;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository implements CrudRepository<Employee> {

	private final DSLContext dsl;

	@Override
	public Employee insert(Employee employee) {
		return dsl.insertInto(Tables.EMPLOYEE)
				.set(dsl.newRecord(Tables.EMPLOYEE,employee ))
				.returning()
				.fetchOne()
				.into(Employee.class);
	}

/*	public Employee	createEmployee(Employee employee){
		EmployeeRecord employeeRecord =dsl.insertInto(Tables.EMPLOYEE)
				.set(Tables.EMPLOYEE.LEADER, employee.getLeader())
				.set(Tables.EMPLOYEE.BRANCH,employee.getBranch())
				.set(Tables.EMPLOYEE.FULLNAME,employee.getFullname())
				.returning(Tables.EMPLOYEE.ID)
				.fetchOne();
		employee.setId(employeeRecord.getId());
		return employee;
	}*/

	@Override
	public Employee update(Employee employee) {
		return dsl.update(Tables.EMPLOYEE)
				.set(dsl.newRecord(Tables.EMPLOYEE, employee))
				.where(Tables.EMPLOYEE.ID.eq(employee.getId()))
				.returning()
				.fetchOne()
				.into(Employee.class);
	}

	@Override
	public Employee find(Long id) {
		return dsl.selectFrom(Tables.EMPLOYEE)
				.where(Tables.EMPLOYEE.ID.eq(id))
				.fetchAny()
				.into(Employee.class);
	}

	@Override
	public List<Employee> findAll(Condition condition) {
		return dsl.selectFrom(Tables.EMPLOYEE)
				.where((Collection<? extends org.jooq.Condition>) condition)
				.fetch()
				.into(Employee.class);
	}

	@Override
	public Boolean delete(Long id) {
		return dsl.deleteFrom(Tables.EMPLOYEE)
				.where(Tables.EMPLOYEE.ID.equal(id))
				.execute() == SUCCESS_CODE;
	}

}

