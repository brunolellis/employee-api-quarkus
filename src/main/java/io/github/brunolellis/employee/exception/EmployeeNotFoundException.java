package io.github.brunolellis.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(final String id) {
		super(String.format("Employee %s not found", id));
	}
}
