package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
	
	List<Machine>findByMachineTag(String machineTag);
	

}
