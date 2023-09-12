package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Projectdata;
import com.example.demo.Repository.ProjectFetchData;

@Service
public class ProjectServices {
	@Autowired
	ProjectFetchData fetchdata;
	public Optional<Projectdata> read(Long id) {
		
		return fetchdata.findById(id);
	}

	public Projectdata create(Projectdata details) {
		
		return fetchdata.save(details);
	}

	public Projectdata update(Projectdata details) {
		return fetchdata.save(details);
	}

	public void delete(Long id) {
		fetchdata.deleteById(id);
		
	}

}
