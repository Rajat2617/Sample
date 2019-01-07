package com.jspiders.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.login.dao.UserDAO;
import com.jspiders.login.dto.LoginDTO;
import com.jspiders.login.dto.UserDTO;

@Service
public class LoginService {

	@Autowired
	private UserDAO userDAO;

	public UserDTO login(LoginDTO login) {

		String loginString = login.getLogin();

		if (loginString.contains("@") && loginString.contains(".")) {
			return userDAO.findByEmail(loginString);
		}
		try {
			return userDAO.findByMobile(Long.parseLong(loginString) + "");
		} catch (Exception e) {
			return userDAO.findByName(loginString);
		}
	}

	public void deleteUser(long id) {
		userDAO.deleteUser(id);
	}
	
	public void deleteUserUsingQuery(long id) {
		userDAO.deleteByQuery(id);
	}

}
