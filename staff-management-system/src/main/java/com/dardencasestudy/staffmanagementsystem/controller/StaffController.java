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

import com.dardencasestudy.staffmanagementsystem.dto.StaffsDto;
import com.dardencasestudy.staffmanagementsystem.model.Staffs;
import com.dardencasestudy.staffmanagementsystem.service.StaffServiceImpl;


@RestController
@RequestMapping("/api/Staff")
public class StaffController {

	@Autowired
	private StaffServiceImpl service;

	public StaffController(StaffServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<StaffsDto> createCourse( @RequestBody StaffsDto Staff) {
		
		StaffsDto save=service.createData(Staff);
		return new ResponseEntity<>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StaffsDto>> getAllList(){
		List<StaffsDto> list=service.getAllstaffs();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<StaffsDto> updateCourse(@PathVariable("id") int sid,  @RequestBody StaffsDto Staff){
		
		Staff.setStaffId(sid);

		StaffsDto update=service.update(Staff);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<StaffsDto> getByCourseId(@PathVariable("id") int sid){
		StaffsDto student=service.getByStaffId(sid);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deteleById(@PathVariable("id") int sid){
		service.deleteById(sid);
		return new ResponseEntity<String>("Project Data delete Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getAllQualifiedStaffs")
	public ResponseEntity<List<Staffs>> getAllQualifiedStaffs(){
		List<Staffs> list=service.getAllQualifiedStaffs();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	

}
