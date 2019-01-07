package com.jspiders.login.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb1_user")
public class UserDTO implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "")
	private long id;
	@Column(name = "user_email", unique = true)
	private String eMail;
	@Column(name = "user_name", unique = true)
	private String name;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_mobile_no", unique = true)
	private String mobileNumber;
	@Column(name = "user_role")
	private String role;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@OneToOne(mappedBy = "userDTO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private UserDetailDTO detailDTO;

	public UserDTO(long id, String eMail, String name, String password, String mobileNumber, String role,
			Date dateOfJoining) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.name = name;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.dateOfJoining = dateOfJoining;
	}

	public UserDTO() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public UserDetailDTO getDetailDTO() {
		return detailDTO;
	}

	public void setDetailDTO(UserDetailDTO detailDTO) {
		this.detailDTO = detailDTO;
	}

}
