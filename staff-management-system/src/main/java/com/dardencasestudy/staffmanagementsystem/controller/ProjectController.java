package com.dardencasestudy.staffmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dardencasestudy.staffmanagementsystem.dto.ProjectsDto;
import com.dardencasestudy.staffmanagementsystem.service.ProjectsService;


@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectsService projectService;

	public ProjectController(ProjectsService projectService) {
		super();
		this.projectService = projectService;
	}
	
	
	
	@PostMapping("/create/{sid}")
	public ResponseEntity<ProjectsDto> createProjectDto( @RequestBody ProjectsDto projectDto,@PathVariable("sid") int sid) {
		
		ProjectsDto save=projectService.createData(projectDto, sid);
		
		return new ResponseEntity<>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProjectsDto>> getAllList(){
		List<ProjectsDto> list=projectService.getAllProjects();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	

	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProjectsDto> getByProjectId(@PathVariable("id") int pid){
		ProjectsDto id=projectService.getByProjectId(pid);
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int pid){
		projectService.deleteById(pid);
		return new ResponseEntity<String>("projectDto Data delete Successfully",HttpStatus.OK);
	}
	

}