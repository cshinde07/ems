package com.mtree.ems.service;

import com.mtree.ems.entity.Employee;

public interface Service<T> {

	/*
	 * READ
	 */
	public  T findById(Long id);

	/**
	 * CREATE
	 * @param e
	 * @return
	 */
	public Long create(Employee e);

	/**
	 * 
	 * @return
	 */
	
	public void update(Employee e);


	/**
	 * 
	 * @param id
	 * @return
	 */
	public void delete(long id);

}