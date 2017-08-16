package com.mtree.ems.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mtree.ems.dao.GenericDao;
import com.mtree.ems.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	private GenericDao<Employee, Serializable> dao;
			
	/**
	 * @param dao the dao to set
	 */
	public void setDao(GenericDao<Employee, Serializable> dao) {
		this.dao = dao;
	}

	@Override
	public Employee findById(Long id) {
		return dao.read(id);
	}

	@Override
	@Transactional("transactionManager")
	public Long create(Employee e) {
		return dao.create(e).getId();
	}

	@Override
	@Transactional("transactionManager")
	public void update(Employee e) {
		 dao.update(e);
	}

	@Override
	@Transactional("transactionManager")

	public void delete(long id) {
		 dao.delete(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
}