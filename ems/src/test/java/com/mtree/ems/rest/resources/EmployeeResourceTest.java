package com.mtree.ems.rest.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mtree.ems.entity.Employee;
import com.mtree.ems.service.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ems-context.xml"})

public class EmployeeResourceTest extends JerseyTest{
	
	@Autowired
	protected ApplicationContext ac;	
	
    @Override
    protected Application configure() {
		System.out.println("calling target...0");
		ResourceConfig r= new ResourceConfig(Employee.class);
		System.out.println("calling target...1");
        return r;
    }
 	//@Test
    @Ignore
 	public void testEmployeeServiceNotNull(){
 		
 		System.out.println("testing testEmployeeServiceNotNull..");
 		@SuppressWarnings("unchecked")
		Service<Employee> service = (Service<Employee>) ac.getBean("service");
 		assertNotNull(service);
 	}
    
	@Test
	public void testGet() { 

		//Employee e = target("employees/100").request().get(Employee.class);
		//assertEquals("Should return status 200", 200, output.getStatus());
		System.out.println("calling target...#");
		Response output = target("employees/200").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return Employee object.", output.getEntity());
	}
}