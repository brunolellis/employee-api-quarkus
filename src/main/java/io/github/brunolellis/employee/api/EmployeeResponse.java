package io.github.brunolellis.employee.api;

import java.time.LocalDate;

public class EmployeeResponse {

	private String id;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private LocalDate dateOfBirth;
	private LocalDate dateOfEmployment;

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

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", dateOfEmployment=" + dateOfEmployment
				+ "]";
	}

	public static class Builder {
		private String id;
		private String firstName;
		private String middleInitial;
		private String lastName;
		private LocalDate dateOfBirth;
		private LocalDate dateOfEmployment;

		public Builder id(final String id) {
			this.id = id;
			return this;
		}

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

		public EmployeeResponse build() {
			final EmployeeResponse employeeResponse = new EmployeeResponse();
			employeeResponse.id = id;
			employeeResponse.firstName = firstName;
			employeeResponse.middleInitial = middleInitial;
			employeeResponse.lastName = lastName;
			employeeResponse.dateOfBirth = dateOfBirth;
			employeeResponse.dateOfEmployment = dateOfEmployment;
			return employeeResponse;
		}

	}
}
