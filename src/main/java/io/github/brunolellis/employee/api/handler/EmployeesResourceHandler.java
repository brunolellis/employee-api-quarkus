package io.github.brunolellis.employee.api.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import io.github.brunolellis.employee.api.EmployeeRequest;
import io.github.brunolellis.employee.api.EmployeeResponse;
import io.github.brunolellis.employee.domain.Employee;
import io.github.brunolellis.employee.domain.EmployeeService;

/**
 * Handles communication between the api and the backend service, converting objects requests <-> model <-> responses.
 */
@ApplicationScoped
public class EmployeesResourceHandler {

	private final EmployeeService service;

	EmployeesResourceHandler() {
		service = null;
	}

	@Inject
	public EmployeesResourceHandler(final EmployeeService service) {
		this.service = service;
	}

	public EmployeeResponse findEmployeeById(final String id) {
		final Employee employee = service.findById(id);
		return convertToResponse(employee);
	}

	public List<EmployeeResponse> findAllEmployees() {
		final List<EmployeeResponse> response = service.findAll().stream()
				.map(this::convertToResponse)
				.collect(Collectors.toList());
		return response;
	}
	
	public EmployeeResponse create(final EmployeeRequest request) {
		final Employee employee = convertToEmployee(request);
		final Employee newEmployee = service.create(employee);
		return convertToResponse(newEmployee);
	}

	public void update(final String id, @Valid final EmployeeRequest request) {
		final Employee employee = convertToEmployee(request);
		service.update(id, employee);
	}

	public void delete(final String id) {
		service.delete(id);
	}
	
	private Employee convertToEmployee(final EmployeeRequest request) {
		return new Employee.Builder()
				.dateOfBirth(request.getDateOfBirth())
				.dateOfEmployment(request.getDateOfEmployment())
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.middleInitial(request.getMiddleInitial())
				.build();
	}
	
	private EmployeeResponse convertToResponse(final Employee e) {
		return new EmployeeResponse.Builder()
				.dateOfBirth(e.getDateOfBirth())
				.dateOfEmployment(e.getDateOfEmployment())
				.firstName(e.getFirstName())
				.id(e.getId())
				.lastName(e.getLastName())
				.middleInitial(e.getMiddleInitial())
				.build();
	}

}
