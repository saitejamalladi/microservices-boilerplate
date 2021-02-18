package com.org.department.service.service;

import com.org.department.service.entity.Department;
import com.org.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment() method of DepartmentService");
		return departmentRepository.save(department);
	}
	public Department findDepartmentById(long departmentId) {
		log.info("inside findDepartmentById() method of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
