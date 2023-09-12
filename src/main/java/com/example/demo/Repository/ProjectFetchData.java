package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Projectdata;

@Repository

public interface ProjectFetchData extends JpaRepository<Projectdata, Long>{

}
