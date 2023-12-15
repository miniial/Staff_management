package com.dardencasestudy.staffmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dardencasestudy.staffmanagementsystem.Repo.ProjectsRepository;
import com.dardencasestudy.staffmanagementsystem.Repo.StaffRepository;
import com.dardencasestudy.staffmanagementsystem.dto.StaffsDto;
import com.dardencasestudy.staffmanagementsystem.mapper.Mapper;
import com.dardencasestudy.staffmanagementsystem.model.Projects;
import com.dardencasestudy.staffmanagementsystem.model.Staffs;


@Service
public class StaffServiceImpl {
	
	@Autowired
	private StaffRepository repository;
	
	@Autowired
	private ProjectsRepository projectRepository;
	
	
	public StaffServiceImpl(StaffRepository repository, ProjectsRepository projectRepository) {
		super();
		this.repository = repository;
		this.projectRepository = projectRepository;
	}

	public StaffsDto createData(StaffsDto staff) {
		Staffs toSave = Mapper.mapToStaffs(staff);
		Staffs savedStaff =repository.save(toSave);
		return Mapper.mapToStaffsDTO(savedStaff);
	}
	
	public List<StaffsDto> getAllstaffs(){
		return repository.findAll().stream().map(Mapper::mapToStaffsDTO).collect(Collectors.toList());
				
	}
	public StaffsDto update(StaffsDto staff) {
		
		Staffs existing=repository.findById(staff.getStaffId()).orElseThrow();
		
		existing.setFirstName(staff.getFirstName());
		existing.setLastName(staff.getLastName());
		existing.setEmail(staff.getEmail());
		existing.setSalary(staff.getSalary());
		existing.setJoiningDate(staff.getJoinDate());
		existing.setPhoneNumber(staff.getPhoneNumber());
		Staffs saved =  repository.save(existing);
		return Mapper.mapToStaffsDTO(saved);
	}
	
	public void deleteById(int staffid) {
		repository.deleteById(staffid);
	}
	
	public StaffsDto getByStaffId(int staffid) {
		
		Staffs staff = repository.findById(staffid).orElseThrow();
		return Mapper.mapToStaffsDTO(staff);
	}

	

//	public List<Staffs> getAllQualifiedStaffs() {
//		// TODO Auto-generated method stub
//		List<Staffs> sl=repository.findAll();
//		List<Staffs> QualifiedStaffs=new ArrayList<Staffs>();
//		for(int i=0;i<sl.size();i++) {
//			if(sl.get(i).getSalary()>30000.0 && sl.get(i).getJoinDate().getYear()==2023) {
//				List<Projects> p=projectRepository.findByStaffId(sl.get(i));
//				if(p.size()>1) {
//					QualifiedStaffs.add(sl.get(i));
//					p.clear();
//					
//				}
//				else {
//					p.clear();
//				}
//				
//			}
//		}
//		
//		return QualifiedStaffs;
//	}
	

	public List<Staffs> getAllQualifiedStaffs() {
	    return repository.findAll().stream()
	            .filter(staff -> staff.getSalary() > 30000.0 && staff.getJoiningDate().getYear() == 2023)
	            .filter(staff -> projectRepository.findByStaffId(staff).size() > 1)
	            .collect(Collectors.toList());
	}
}
