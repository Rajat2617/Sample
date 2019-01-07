package com.jspiders.login.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.login.dao.UserDAO;
import com.jspiders.login.dto.UserDTO;

@Service
public class UserService implements Serializable {

	@Autowired
	private UserDAO userDAO;

	public long saveUser(UserDTO userDTO) {
		Date date = new Date();
		userDTO.setDateOfJoining(date);

		String encodededPassword = encodePassword(userDTO.getPassword());
		userDTO.setPassword(encodededPassword);

		return userDAO.saveUser(userDTO);
	}

	public static String encodePassword(String password) {
		String encode = "!@#$%^&*()";
		String out = "";

		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i);
			while (c > 0) {
				char ch = encode.charAt(c % 10);
				out = ch + out;
				c = c / 10;
			}
		}
		return out;
	}

	public UserDTO findById(long id) {

		return userDAO.findById(id);
	}

	public void updateUSer(UserDTO dto) {
		userDAO.updateUser(dto);
	}

}
