package com.dardencasestudy.staffmanagementsystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Staffs")
public class Staffs {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true,nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	private Double salary;
	
	@Column(nullable = false)
	private LocalDate joiningDate;
	
	
	
	


}
