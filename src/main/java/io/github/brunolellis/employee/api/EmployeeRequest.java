package io.github.brunolellis.employee.api;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class EmployeeRequest {

	@NotNull
	@Size(max = 50)
	private String firstName;

	@Size(max = 1)
	private String middleInitial;

	@NotNull
	@Size(max = 50)
	private String lastName;

	@NotNull
	@Valid
	private LocalDate dateOfBirth;

	@NotNull
	@Valid
	private LocalDate dateOfEmployment;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(final String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(final LocalDate dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfEmployment=" + dateOfEmployment + "]";
	}

}
