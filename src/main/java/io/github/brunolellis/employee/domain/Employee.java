package io.github.brunolellis.employee.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "EMPLOYEE")
public class Employee {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "ID")
	private String id;

	// @Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	// @Column(name = "MIDDLE_INITIAL", length = 1)
	private String middleInitial;

	// @Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	// @Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;

	// @Column(name = "DATE_OF_EMPLOYMENT", nullable = false)
	private LocalDate dateOfEmployment;

	// @Enumerated(EnumType.STRING)
	// @Column(name = "STATUS", nullable = false)
	private EmployeeStatus status = EmployeeStatus.ACTIVE;

	public Employee generateNewId() {
		if (id == null) {
			this.id = UUID.randomUUID().toString();
		}

		return this;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public boolean isActive() {
		return this.status == EmployeeStatus.ACTIVE;
	}

	public boolean isInactive() {
		return !isActive();
	}

	public void enable() {
		this.status = EmployeeStatus.ACTIVE;
	}

	public void disable() {
		this.status = EmployeeStatus.INACTIVE;
	}

	private Employee() {
	}

	public static class Builder {
		private String firstName;
		private String middleInitial;
		private String lastName;
		private LocalDate dateOfBirth;
		private LocalDate dateOfEmployment;
		// 'status' should not be exposed

		public Builder firstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder middleInitial(final String middleInitial) {
			this.middleInitial = middleInitial;
			return this;
		}

		public Builder lastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder dateOfBirth(final LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder dateOfEmployment(final LocalDate dateOfEmployment) {
			this.dateOfEmployment = dateOfEmployment;
			return this;
		}

		public Employee build() {
			final Employee employee = new Employee();
			employee.firstName = firstName;
			employee.middleInitial = middleInitial;
			employee.lastName = lastName;
			employee.dateOfBirth = dateOfBirth;
			employee.dateOfEmployment = dateOfEmployment;
			return employee;
		}

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", dateOfEmployment=" + dateOfEmployment + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, dateOfEmployment, firstName, id, lastName, middleInitial, status);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Employee other = (Employee) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(dateOfEmployment, other.dateOfEmployment)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleInitial, other.middleInitial)
				&& status == other.status;
	}

}
