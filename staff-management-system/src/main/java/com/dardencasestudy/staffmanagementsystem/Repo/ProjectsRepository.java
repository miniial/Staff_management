package com.dardencasestudy.staffmanagementsystem.Repo;


import com.dardencasestudy.staffmanagementsystem.model.Projects;
import com.dardencasestudy.staffmanagementsystem.model.Staffs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Integer> {

	List<Projects> findByStaffId(Staffs s);
}
