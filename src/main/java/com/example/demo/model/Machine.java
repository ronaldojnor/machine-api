package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Machine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "machine_tag", nullable = false, length = 24) 
	private String machineTag;
	
	private String startTime;
	
	private String endTime;
		
	private String reason;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(nullable = false)
//	private Date startTime;
//	@PrePersist
//	private void onCreate() {
//		startTime = new Date();
//	}

}
