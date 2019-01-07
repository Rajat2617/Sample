package com.jspiders.login.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail_table")
public class UserDetailDTO implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "user_detail_id")
	private long id;
	@Column(name = "user_no_of_family")
	private int noOfFamily;
	@Column(name = "user_salary")
	private double salary;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "flatNumber", column = @Column(name = "user_flatnumber")),
			@AttributeOverride(name = "colony", column = @Column(name = "user_colony")),
			@AttributeOverride(name = "city", column = @Column(name = "user_city")),
			@AttributeOverride(name = "state", column = @Column(name = "user_state")),
			@AttributeOverride(name = "pincode", column = @Column(name = "user_pincode1")) })
	private Address address;
	@Column(name = "user_govt_id_proof")
	private String govtIdProof;
	@Column(name = "user_experience")
	private int experience;
	@Column(name = "user_used_technologies")
	private String usedTechnologies;
	
	@OneToOne
	private UserDTO userDTO;

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNoOfFamily() {
		return noOfFamily;
	}

	public void setNoOfFamily(int noOfFamily) {
		this.noOfFamily = noOfFamily;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getGovtIdProof() {
		return govtIdProof;
	}

	public void setGovtIdProof(String govtIdProof) {
		this.govtIdProof = govtIdProof;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getUsedTechnologies() {
		return usedTechnologies;
	}

	public void setUsedTechnologies(String usedTechnologies) {
		this.usedTechnologies = usedTechnologies;
	}

}
