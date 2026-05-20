package com.sinlee.jobtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a job application. It stores information like
 * company name, role applied for, and application status.
 */

@Entity
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Each application's id

	private String company;

	private String role;// aka position

	public enum Status {
		APPLIED, INTERVIEW, REJECTED, OFFER
	} // major status, can add if needed.

	@Enumerated(EnumType.STRING)
	private Status status;

	// constructor for JPA
	public JobApplication() {

	}

	public JobApplication(String company, String role, Status status) {
		this.company = company;
		this.role = role;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public String getRole() {
		return role;
	}

	public Status getStatus() {
		return status;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
