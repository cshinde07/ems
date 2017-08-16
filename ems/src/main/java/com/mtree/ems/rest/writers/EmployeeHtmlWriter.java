package com.mtree.ems.rest.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import com.mtree.ems.entity.Employee;

//@Provider
//@Produces("text/html")
public class EmployeeHtmlWriter implements MessageBodyWriter<Employee> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Employee.class;
	}

	@Override
	public long getSize(Employee e, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeTo(Employee e, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		
	    Writer writer = new OutputStreamWriter(entityStream);
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h2>Employee</h2>");
        writer.write("<p>Id: " + e.getId() + "</p>");
        writer.write("<p>Name: " + e.getName() + "</p>");
        writer.write("</body>");
        writer.write("</html>");
        
        writer.flush();
        writer.close();
	}
}