package io.github.brunolellis.employee.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import io.github.brunolellis.employee.domain.Employee;
import io.github.brunolellis.employee.domain.EmployeeStatus;

@ApplicationScoped
@Transactional
public class EmployeeRepository {

    private EntityManager em;

    EmployeeRepository() {
    }

    @Inject
    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public Optional<Employee> findByIdAndStatus(Long id, EmployeeStatus active) {
        Employee employee = em.find(Employee.class, id);

        if (employee == null || employee.isInactive()) {
            return Optional.empty();
        }

        return Optional.of(employee);
    }

    public List<Employee> findAllByStatus(EmployeeStatus status) {
        List<Employee> employees = (List<Employee>) em.createQuery("SELECT e FROM Employee e WHERE e.status = :status")
                        .setParameter("status", status)
                        .getResultList();
        return employees;
	}

	public Employee save(Employee employee) {
        if (employee.getId() != null) {
            return em.merge(employee);
        }

        em.persist(employee);
        return employee;
	}

}