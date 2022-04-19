package com.example.testzadanie.service;

import com.example.demo.Tables;
import com.example.demo.tables.pojos.Task;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final DSLContext dslContext;

	public void insertTask(Task task){
		dslContext.insertInto(Tables.TASK,Tables.TASK.PRIORITY,Tables.TASK.EXECUTOR,
				Tables.TASK.DESCRIPTION)
				.values(task.getPriority(), task.getExecutor(),task.getDescription())
				.execute();
	}

	public List<Task> getTask(){
		return dslContext.selectFrom(Tables.TASK)
				.fetchInto(Task.class);
	}

	public void delete(Task task){
	}
}
