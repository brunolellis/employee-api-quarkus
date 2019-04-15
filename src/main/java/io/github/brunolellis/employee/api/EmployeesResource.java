package io.github.brunolellis.employee.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.github.brunolellis.employee.api.handler.EmployeesResourceHandler;

@Path("/api/v1/employees")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class EmployeesResource extends AbstractRestApi {

	private final EmployeesResourceHandler apiHandler;

	public EmployeesResource() {
		apiHandler = null;
	}

	@Inject
	public EmployeesResource(final EmployeesResourceHandler apiHandler) {
		this.apiHandler = apiHandler;
	}

	@GET
	public Response findAll() {
		final List<EmployeeResponse> response = apiHandler.findAllEmployees();
		return Response.ok(response).build();
	}

	@POST
	public Response create(@Valid final EmployeeRequest newEmployee, @Context UriInfo uriInfo) {
		final EmployeeResponse response = apiHandler.create(newEmployee);
		
		URI uriPathLocation = getUriPathLocation(uriInfo, response.getId());
		return Response.created(uriPathLocation)
			.entity(response)
			.build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") final String id) {
		final EmployeeResponse response = apiHandler.findEmployeeById(id);
		return Response.ok(response).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") final String id, @Valid final EmployeeRequest employee) {
		apiHandler.update(id, employee);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	//@RolesAllowed("ADMIN")
	public Response delete(@PathParam("id") final String id) {
		apiHandler.delete(id);
		return Response.noContent().build();
	}

}
