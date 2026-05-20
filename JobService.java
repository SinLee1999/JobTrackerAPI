package com.sinlee.jobtracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinlee.jobtracker.dto.JobRequestDTO;
import com.sinlee.jobtracker.dto.JobResponseDTO;
import com.sinlee.jobtracker.entity.JobApplication;
import com.sinlee.jobtracker.repository.JobRepository;

/**
 * This service class contains the main business logic for managing job
 * applications. It communicates with the repository layer to perform operations
 * like create, read, update, and delete jobs.
 */

@Service
public class JobService {
	private final JobRepository repo;

	public JobService(JobRepository repo) {
		this.repo = repo;
	}

		public List<JobResponseDTO> getAll() {
		List<JobApplication> jobs = repo.findAll(); // get all information from database
		List<JobResponseDTO> list = new ArrayList<JobResponseDTO>();// create empty DTO list

		for (JobApplication job : jobs) {
			JobResponseDTO dto = new JobResponseDTO(job.getId(), job.getCompany(), job.getRole(), job.getStatus());
			list.add(dto);
		}
		return list;
	}

	public Optional<JobResponseDTO> getJob(int id) {
		Optional<JobApplication> optionalJob = repo.findById(id);
		
		if (optionalJob.isEmpty()) {
			return Optional.empty();
		}
		
		JobApplication job = optionalJob.get();
		JobResponseDTO dto = new JobResponseDTO(job.getId(), job.getCompany(), job.getRole(), job.getStatus());
		return Optional.of(dto);
	}

	
	public JobResponseDTO createJob(JobRequestDTO dto) {
		JobApplication job = new JobApplication();
		job.setCompany(dto.getCompany());
		job.setRole(dto.getRole());
		job.setStatus(dto.getStatus());

		JobApplication abc = repo.save(job);

		JobResponseDTO response = new JobResponseDTO(abc.getId(), abc.getCompany(), abc.getRole(), abc.getStatus());
		return response;
	}

	// delete job by id
	public boolean deleteJob(int id) {
		if (!repo.existsById(id)) { // check if repository does not contains user's choice
			return false;
		}

		repo.deleteById(id);
		return true;
	}

	/**
	 * Updates exist job as long as id exist and input is filled properly
	 * 
	 * @param id  - user chooses job to be changed
	 * @param dto - user input that will become the new result
	 * @return updated version from user input
	 */
	public Optional<JobResponseDTO> updateJob(int id, JobRequestDTO dto) {
		Optional<JobApplication> optionalJob = repo.findById(id);//

		if (optionalJob.isEmpty()) {// if job is not found, return empty result
			return Optional.empty();
		}

		JobApplication job = optionalJob.get();

		job.setCompany(dto.getCompany()); // old information is replaced with user input(new data)
		job.setRole(dto.getRole());
		job.setStatus(dto.getStatus());

		JobApplication updated = repo.save(job);

		JobResponseDTO response = new JobResponseDTO(id, updated.getCompany(), updated.getRole(), updated.getStatus());

		return Optional.of(response);
	}
}
