package com.mtree.ems.dao;

import java.io.Serializable;

public interface GenericDao <T , PK extends Serializable> {
	
    T create(T t);
    
    T read(PK id);
 
    void update(T t);
 
    void delete(Class<T> klass,PK id);
}