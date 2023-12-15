package com.dardencasestudy.staffmanagementsystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Projects")
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "staff_id")
	private Staffs staffId;
	
	@Column(nullable = false)
    private String projectName;
	
	@Column(nullable = false)
    private LocalDate TaggingDate;

	@Override
	public String toString() {
		return "Projects [id=" + id + ", staffId=" + staffId + ", projectName=" + projectName + ", TaggingDate="
				+ TaggingDate + "]";
	}
	
	


}
