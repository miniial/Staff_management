package com.dardencasestudy.staffmanagementsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.dardencasestudy.staffmanagementsystem.model.Staffs;

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
public class ProjectsDto {
	
	private int id;

	private Staffs staffId;
	
	private String projectName;
	
	private LocalDate TaggingDate;
	
	


}
