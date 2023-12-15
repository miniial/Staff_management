package com.dardencasestudy.staffmanagementsystem.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dardencasestudy.staffmanagementsystem.Repo.ProjectsRepository;
import com.dardencasestudy.staffmanagementsystem.Repo.StaffRepository;
import com.dardencasestudy.staffmanagementsystem.dto.ProjectsDto;
import com.dardencasestudy.staffmanagementsystem.mapper.Mapper;
import com.dardencasestudy.staffmanagementsystem.model.Projects;
import com.dardencasestudy.staffmanagementsystem.model.Staffs;

@Service
public class ProjectsService {
	
	@Autowired
	private ProjectsRepository projectRepository;
	
	@Autowired
	private StaffRepository staffrepository;
	
	
	public ProjectsService(ProjectsRepository projectRepository, StaffRepository staffrepository) {
		super();
		this.projectRepository = projectRepository;
		this.staffrepository = staffrepository;
	}

	public ProjectsDto createData(ProjectsDto projectDto ,int sid) {
		
		Staffs staff=staffrepository.findById(sid).get();
		Projects project = Mapper.mapToProjects(projectDto);
		project.setStaffId(staff);
		project.setProjectName(projectDto.getProjectName());
		project.setTaggingDate(projectDto.getTaggingDate());
		Projects savedProject = projectRepository.save(project);
		return Mapper.mapToProjectsDTO(savedProject);
	}
	
	public List<ProjectsDto> getAllProjects(){
		return projectRepository.findAll().stream().map(Mapper::mapToProjectsDTO).collect(Collectors.toList());
				
	}	
	public void deleteById(int id) {
		projectRepository.deleteById(id);
	}
	
	public ProjectsDto getByProjectId(int id) {
		
		Projects project = projectRepository.findById(id).orElseThrow();
		return Mapper.mapToProjectsDTO(project);
	}



}
