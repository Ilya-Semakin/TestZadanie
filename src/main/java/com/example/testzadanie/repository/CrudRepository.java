package com.example.testzadanie.repository;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface CrudRepository<T> {

	Integer SUCCESS_CODE = 1;

	T insert(T t);

	T update(T t);

	T find(Long id);

	List<T> findAll(Condition condition);

	Boolean delete(Long id);

}
