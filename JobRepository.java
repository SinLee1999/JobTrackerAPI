package com.sinlee.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinlee.jobtracker.entity.JobApplication;

public interface JobRepository extends JpaRepository<JobApplication, Integer>{
	
}
