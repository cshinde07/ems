/**
 * 
 */
package com.mtree.ems.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mtree.ems.entity.Employee;

/**
 * @author M1038946
 *
 */
public  class GenericaJpaDaoImpl<T , PK extends Serializable>  implements GenericDao<T, PK> {


	@PersistenceContext
	private EntityManager em;
	
	@Override
	public T create(T t) {
		
		 this.em.persist(t);
	     this.em.flush();
	     this.em.refresh(t);
	     return t;
	}

    @SuppressWarnings("unchecked")
	@Override
	public T read(PK id) {
    	try {
			String query = "SELECT e FROM Employee e WHERE e.id = ?1";
			TypedQuery<Employee> typedQuery = em.createQuery(query, Employee.class);
			typedQuery.setParameter(1, id);
			
			return (T) typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
		
	}

	@Override
	public void update(T t) {
        this.em.merge(t);
	}

	@Override
	public void delete(Class<T> klass, PK id) {
	   T t = this.em.getReference(klass, id);
       this.em.remove(t);
	}

	
}
