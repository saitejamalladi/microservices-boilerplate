package com.org.user.service.controller;

import com.org.user.service.VO.ResponseTemplateVO;
import com.org.user.service.entity.User;
import com.org.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser() of UserController");
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplateVO findUserWithId(@PathVariable("id") Long userId) {
		log.info("Inside findUserById() of UserController");
		return userService.findUserWithId(userId);
	}
}
