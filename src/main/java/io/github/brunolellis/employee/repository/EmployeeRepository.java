package io.github.brunolellis.employee.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

import io.github.brunolellis.employee.domain.Employee;
import io.github.brunolellis.employee.domain.EmployeeStatus;

@ApplicationScoped
public class EmployeeRepository {

    private Map<String, Employee> employees = new ConcurrentHashMap<>();

    public EmployeeRepository() {
        Employee e = new Employee.Builder()
            .dateOfBirth(LocalDate.now())
            .dateOfEmployment(LocalDate.now())
            .firstName("First")
            .lastName("Last")
            .middleInitial("M")
            .build()
            .generateNewId();
        this.employees.put(e.getId(), e);
    }

	public Optional<Employee> findByIdAndStatus(String id, EmployeeStatus active) {
        Employee employee = employees.get(id);

        if (employee == null || employee.isInactive()) {
            return Optional.empty();
        }

		return Optional.of(employee);
	}

	public List<Employee> findAllByStatus(EmployeeStatus active) {
		return new ArrayList<>(employees.values());
	}

	public Employee save(Employee employee) {
        employee.generateNewId();
        employees.put(employee.getId(), employee);
        return employee;
	}

}