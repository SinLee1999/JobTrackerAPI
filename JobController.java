package com.sinlee.jobtracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinlee.jobtracker.dto.JobRequestDTO;
import com.sinlee.jobtracker.dto.JobResponseDTO;
import com.sinlee.jobtracker.service.JobService;

import jakarta.validation.Valid;

/**
 * This controller handles all HTTP requests for job applications while communication with the service layer.
 */

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private final JobService service;
	
	public JobController(JobService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<JobResponseDTO>> getAll(){
		List<JobResponseDTO> lists = service.getAll();
		
		return ResponseEntity.ok(lists);
	}
	
	// get one job by id
	@GetMapping("/{id}")
	public ResponseEntity<JobResponseDTO> getJob(@PathVariable int id){
		Optional<JobResponseDTO> opt = service.getJob(id);
		
		if(opt.isPresent()) {// job page containing id
			JobResponseDTO job = opt.get();
			return ResponseEntity.ok(job);
		} 
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody JobRequestDTO input) {
		JobResponseDTO result = service.createJob(input);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable int id){
		boolean deleted = service.deleteJob(id);
		
		if(!deleted) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobResponseDTO> updateJob(@PathVariable int id, @Valid @RequestBody JobRequestDTO input) {	
		Optional<JobResponseDTO> updated = service.updateJob(id, input);
		
		if(updated.isPresent()) {// return updated job if the update succeeded
			return ResponseEntity.ok(updated.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}
