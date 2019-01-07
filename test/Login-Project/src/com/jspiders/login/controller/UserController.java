package com.jspiders.login.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jspiders.login.dto.UserDTO;
import com.jspiders.login.service.LoginService;
import com.jspiders.login.service.UserService;

@Controller
@RequestMapping("*")
public class UserController implements Serializable {

	@Autowired
	private UserService service;

	@Autowired
	private LoginService lService;

	@PostMapping("/saveUser.do")
	public ModelAndView saveUser(UserDTO userDTO) {
		long id = service.saveUser(userDTO);
		if (id > 0) {
			return new ModelAndView("success.jsp");
		} else {
			return new ModelAndView("failure.jsp");
		}
	}

	@PostMapping("/updateUser.do")
	ModelAndView updateUser(UserDTO userFormHtml, HttpServletRequest request) {

		// http session object
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		int id = (int) request.getSession().getAttribute("userId");

		// give a object from database
		UserDTO userFromDataBase = service.findById(user.getId());
		UserDTO userFromDataBase2 = service.findById(id);

		userFromDataBase.seteMail(userFormHtml.geteMail());
		userFromDataBase.setMobileNumber(userFormHtml.getMobileNumber());
		userFromDataBase.setName(userFormHtml.getName());

		// complte object
		// userFromDataBase

		service.updateUSer(userFromDataBase);

		return new ModelAndView("failure.jsp");
	}

	@GetMapping("/deleteUser.do")
	public ModelAndView deleteUser(@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			HttpServletRequest request) {

		System.out.println("delete method has been invoked");

		Object attribute = request.getSession().getAttribute("user");
		UserDTO user = (UserDTO) attribute;

		System.out.println("user ---- >> " + user);
		String pwd3 = user.getPassword();

		System.out.println(pwd3);
		if (pwd1.equals(pwd2) && service.encodePassword(pwd2).equals(pwd3)) {
			lService.deleteUserUsingQuery(user.getId());

			return new ModelAndView("deletedUser.jsp", "msg", "Success");
		}

		return new ModelAndView("delete.jsp", "msg", "Credentials Mismatch");
	}

}
