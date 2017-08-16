package com.mtree.ems.rest.resources.expcetionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception e) {    	
    	
        return Response
		        .status(Response.Status.BAD_REQUEST.getStatusCode())
		        .entity("Catching in ApplicaitonExceptionMapper : " + e.getMessage())
		        .build();
    }
}