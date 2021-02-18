package com.org.department.service.controller;

import com.org.department.service.entity.Department;
import com.org.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping("")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment() method of Department Controller");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("inside findDepartmentById() method of Department Controller");
		return departmentService.findDepartmentById(departmentId);
	}

}
