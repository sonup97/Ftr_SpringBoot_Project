package com.infy.ftr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.infy.ftr.dto.UserProfileDTO;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ftr_user")
public class UserProfileEntity {

	@Column(name = "user_id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")

	@Id
	private Integer userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private Long mobileNumber;
	private String password;
	private String nationality;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "office_address")
	private String officeAddress;

	@Column(name = "personal_identification_number")
	private Long personalIdentificationNumber;

	UserProfileEntity() {

	}

	public UserProfileEntity(UserProfileDTO userDTO) {
		
		setFirstName(userDTO.getFirstName());
		setLastName(userDTO.getLastName());
		setEmailId(userDTO.getEmailId());
		setMobileNumber(userDTO.getMobileNumber());
		setPassword(userDTO.getPassword());
		setNationality(userDTO.getNationality());
		setPassportNumber(userDTO.getPassportNumber());
		setPermanentAddress(userDTO.getPermanentAddress());
		setOfficeAddress(userDTO.getOfficeAddress());
		setPersonalIdentificationNumber(userDTO.getPersonalIdentificationNumber());
	}

	public static UserProfileDTO prepareUserDto(UserProfileEntity userEntity) {
		return new UserProfileDTO(userEntity);
	}

	@Override
	public String toString() {
		return "UserProfileEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", nationality=" + nationality + ", passportNumber=" + passportNumber + ", permanentAddress="
				+ permanentAddress + ", officeAddress=" + officeAddress + ", personalIdentificationNumber="
				+ personalIdentificationNumber + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(Long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
}
