package com.dardencasestudy.staffmanagementsystem.mapper;

import com.dardencasestudy.staffmanagementsystem.dto.ProjectsDto;
import com.dardencasestudy.staffmanagementsystem.dto.StaffsDto;
import com.dardencasestudy.staffmanagementsystem.model.Projects;
import com.dardencasestudy.staffmanagementsystem.model.Staffs;

public class Mapper {
	public static StaffsDto mapToStaffsDTO(Staffs staffs) {
        if (staffs == null) return null;
        StaffsDto staffsDto = new StaffsDto();
        staffsDto.setStaffId(staffs.getStaffId());
        staffsDto.setFirstName(staffs.getFirstName());
        staffsDto.setLastName(staffs.getLastName());
        staffsDto.setEmail(staffs.getEmail());
        staffsDto.setPhoneNumber(staffs.getPhoneNumber());
        staffsDto.setSalary(staffs.getSalary());
        staffsDto.setJoinDate(staffs.getJoiningDate());
        return staffsDto;
    }

    public static Staffs mapToStaffs(StaffsDto staffsDto) {
        if (staffsDto == null) return null;
        Staffs staffs = new Staffs();
        staffs.setStaffId(staffsDto.getStaffId());
        staffs.setFirstName(staffsDto.getFirstName());
        staffs.setLastName(staffsDto.getLastName());
        staffs.setEmail(staffsDto.getEmail());
        staffs.setPhoneNumber(staffsDto.getPhoneNumber());
        staffs.setSalary(staffsDto.getSalary());
        staffs.setJoiningDate(staffsDto.getJoinDate());
        return staffs;
    }

    // Projects mapping
    public static ProjectsDto mapToProjectsDTO(Projects projects) {
        if (projects == null) return null;
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.setId(projects.getId());
        projectsDto.setStaffId(projects.getStaffId());
        projectsDto.setProjectName(projects.getProjectName());
        projectsDto.setTaggingDate(projects.getTaggingDate());
        return projectsDto;
    }

    public static Projects mapToProjects(ProjectsDto projectsDto) {
        if (projectsDto == null) return null;
        Projects projects = new Projects();
        projects.setId(projectsDto.getId());
        projects.setStaffId(projectsDto.getStaffId());
        projects.setProjectName(projectsDto.getProjectName());
        projects.setTaggingDate(projectsDto.getTaggingDate());
        return projects;
    }}
