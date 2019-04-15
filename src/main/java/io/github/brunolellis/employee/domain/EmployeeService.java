package io.github.brunolellis.employee.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.github.brunolellis.employee.exception.EmployeeNotFoundException;
import io.github.brunolellis.employee.repository.EmployeeRepository;

@ApplicationScoped
public class EmployeeService {

	private final EmployeeRepository repository;

	EmployeeService() {
		repository = null;
	}

	@Inject
	public EmployeeService(final EmployeeRepository repository) {
		this.repository = repository;
	}

	/**
	 * retrieves the specified employee's id. note: the employee should be active.
	 * 
	 * @param id
	 * @return
	 * @throws EmployeeNotFoundException in case it does not exist (or maybe because it was previously disabled) 
	 */
	public Employee findById(final String id) throws EmployeeNotFoundException {
		return repository.findByIdAndStatus(id, EmployeeStatus.ACTIVE)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	public List<Employee> findAll() {
		return repository.findAllByStatus(EmployeeStatus.ACTIVE);
	}

	/**
	 * deletes (in fact, disables) an existing employee id.
	 * 
	 * @param id
	 * @throws EmployeeNotFoundException
	 */
//////////////////////////////////////////////////////////////////////// @Transactional(readOnly = false)
	public void delete(final String id) throws EmployeeNotFoundException {
		final Employee employee = findById(id);

		employee.disable();
		repository.save(employee);
	}

	/**
	 * creates an active employee
	 * 
	 * @param employee
	 * @return
	 */
//////////////////////////////////////////////////////////////////////// @Transactional(readOnly = false)
	public Employee create(final Employee employee) {
		employee.enable();
		return repository.save(employee);
	}

	/**
	 * updates an existing employee. the EmployeeStatus is **not** going to be
	 * updated.
	 * @param id 
	 * 
	 * @param employee
	 * @throws EmployeeNotFoundException
	 */
//////////////////////////////////////////////////////////////////////// @Transactional(readOnly = false)
	public void update(final String id, final Employee employee) throws EmployeeNotFoundException {
		final Employee updatingEmployee = findById(id);
		
		employee.setId(updatingEmployee.getId());
		employee.enable();
		repository.save(employee);
	}

}
