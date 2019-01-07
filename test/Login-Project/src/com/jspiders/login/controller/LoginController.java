package com.jspiders.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspiders.login.dto.LoginDTO;
import com.jspiders.login.dto.UserDTO;
import com.jspiders.login.service.LoginService;
import com.jspiders.login.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	UserService userService;

	@PostMapping("/login.do")
	public ModelAndView login(LoginDTO loginDTO, HttpServletRequest req) {
		UserDTO userDTO = service.login(loginDTO);
		if (userDTO.getPassword().equals(userService.encodePassword(loginDTO.getPassword()))) {

			if (userDTO.getRole().equalsIgnoreCase("user")) {
				req.getSession().setAttribute("user", userDTO);
				 req.setAttribute("userLogin", userDTO);
				return new ModelAndView("userdashboard.jsp", "user", userDTO);
			} else {
				req.getSession().setAttribute("user", userDTO);
				 req.setAttribute("userLogin", userDTO);
				return new ModelAndView("admindashboaard.jsp", "user", userDTO);
			}
		}
		return new ModelAndView("failure.jsp", "user", userDTO);
	}

}
