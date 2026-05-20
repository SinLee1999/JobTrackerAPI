package com.sinlee.jobtracker.dto;

import com.sinlee.jobtracker.entity.JobApplication.Status;


/**
 * DTO class used for returning job application data to users.
 * It sends response data back to the client.
 */
public class JobResponseDTO {
	private int id;
    private String company;
    private String role;
    private Status status;

    public JobResponseDTO(int id, String company, String role, Status status) {
    	this.id = id;
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
}