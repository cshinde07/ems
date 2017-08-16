package com.mtree.ems.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtree.ems.entity.Employee;
import com.mtree.ems.service.EmployeeService;
/**
 * Root employee resource class
 * @author cshinde
 * 
 * Performs CRUD operations on employee resource.
 * 
 * GET /employees/1 --> return employee with id 1
 * POST /employees  --> create new employee
 * PUT /employees   --> update employees
 * DELETE /employees/2 --> delete employee with id 2
 */

@Component
@Path("employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;

    /**
	 * @return the service
	 */
	public EmployeeService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(EmployeeService service) {
		this.service = service;
	}

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     */
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML})
    @Path("{id}")
    public Employee  get(@PathParam("id") Long id){
		System.out.println("calling..");
		return service.findById(id);
	}

    /**
     * Method handling HTTP POST requests.
     * @param t
     * @return
     */
	@POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public  Response   post(Employee e){
		Long id = service.create(e);
		e.setId(id);
		
		return Response.status(Response.Status.CREATED)// 201
				.entity(e)
				.header("Location",
						"http://localhost:8080/rest/employees/"
								+ String.valueOf(id)).build();
	}
    
    /**
     * Method handling HTTP DELETE requests.
     * @param id
     * @return
     */
    @DELETE
	@Produces({ MediaType.TEXT_HTML })
    @Path("{id}")
    public Response delete(@PathParam("id") long id){
    	service.delete(id);
		return Response.status(Response.Status.NO_CONTENT)// 204
				.entity("Employee removed from database").build();  
	}
    
    /**
     * Method handling HTTP PUT requests.
     * @param t
     * @return
     */
	@PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response  put(Employee e){
		service.update(e);
		return Response
				.status(Response.Status.OK)// 200
				.entity(e)
				.header("Location",
						"http://localhost:8080/rest/employees/"
								+ String.valueOf(e.getId())).build();
	}
	
}