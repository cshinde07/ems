/**
Class Employee
*/
package com.mtree.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Employee")
@XmlRootElement
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "id")
	protected Long id;

	@Column(name = "name")
	private String name;
	
	@Column
	private int salary;
	
	@Column
	private String city;

	public Employee() {
	}

	public Employee(Long id, String firstName) {
		this.id = id;
		this.name = firstName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}