package com.org.user.service.service;

import com.org.user.service.VO.Department;
import com.org.user.service.VO.ResponseTemplateVO;
import com.org.user.service.entity.User;
import com.org.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser() of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO findUserWithId(Long userId) {
		log.info("Inside findUserWithUserId() of UserService");
		User user = userRepository.findByUserId(userId);
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		responseTemplateVO.setUser(user);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
						Department.class);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
