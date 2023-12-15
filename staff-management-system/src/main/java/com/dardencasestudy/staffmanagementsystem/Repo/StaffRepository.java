package com.dardencasestudy.staffmanagementsystem.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dardencasestudy.staffmanagementsystem.model.Staffs;


@Repository
public interface StaffRepository extends JpaRepository<Staffs, Integer>{
	

}
