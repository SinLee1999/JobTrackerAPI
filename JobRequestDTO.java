package com.sinlee.jobtracker.dto;

import com.sinlee.jobtracker.entity.JobApplication.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO class used for creating and updating job applications.
 * It receives user input from HTTP requests.
 */	
public class JobRequestDTO {
	
    @NotBlank
    private String company;

    @NotBlank
    private String role;

    @NotNull
    private Status status;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}