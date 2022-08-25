package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Machine;
import com.example.demo.repository.MachineRepository;

@RestController
@RequestMapping("/machine-halt")
public class MachineController {

	@Autowired
	private MachineRepository machineRepository;
	
	@GetMapping
	public List<Machine> listar() {
		return machineRepository.findAll();
	}
	
	@PostMapping
	public Machine adicionar(@RequestBody Machine machine) {
		return machineRepository.save(machine);
	}
	
	@GetMapping("/{id}")
	public Optional<Machine> id(@PathVariable Long id) {
	    return machineRepository.findById(id);
	}
	
	@GetMapping("/list/{machineTag}")
	public ResponseEntity<List<Machine>> tag(@PathVariable String machineTag) {
	    return new ResponseEntity<List<Machine>>(machineRepository.findByMachineTag(machineTag), HttpStatus.OK);
	}
	
	@DeleteMapping("/all")
	public List<Machine> delete() {
		List<Machine> machine = machineRepository.findAll();
		machineRepository.deleteAll(machine);
		return null;
	}
	
	@PutMapping
	public Machine finalizaParada(@RequestBody Machine machine) {
		return machineRepository.save(machine);
	}
	
//	@PutMapping
//	public Machine alteraMotivo(@RequestBody Machine machine) {
//		return machineRepository.save(machine);
//	}
	

}
	