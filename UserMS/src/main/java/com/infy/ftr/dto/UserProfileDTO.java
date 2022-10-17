package com.infy.ftr.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.infy.ftr.entity.UserProfileEntity;



public class UserProfileDTO {

	Integer userId;

	@NotNull(message = "{user.firstName.must}")
	@Size(max = 20,message = "{user.firstName.invalid}")
	String firstName;

	@NotNull(message = "{user.lastName.must}")
	@Size(max = 20,message = "{user.lastName.invalid}")
	String lastName;

	@NotNull(message = "{user.email.must}")
	@Email(message = "{user.email.invalid}")
	String emailId;

	@NotNull(message = "{user.phone.must}")
	@Max(value = 9999999999l, message = "{user.phone.invalid}")
	@Min(value = 1000000000l, message = "{user.phone.invalid}")
	private Long mobileNumber;

	@NotNull(message = "{user.password.must}")
	@Pattern(regexp = "[A-z0-9]*[!@#$%^&*()_+:;><]+[A-z0-9]*", message = "{user.password.invalid}")
	@Size(min = 7, max = 15, message = "{user.password.invalidsize}")
	private String password;

	@NotNull(message = "{user.nationality.must}")
	@Size(max = 20, message = "{user.nationality.invalid}")
	private String nationality;

	@NotNull(message = "{user.passportNumber.must}")
	@Size(min = 7,max = 12, message = "{user.passportNumber.invalid}")
	private String passportNumber;

	@NotNull(message = "{user.permanentAddress.must}")
	@Size(max = 200, message = "{user.permanentAddress.invalid}")
	private String permanentAddress;

	@NotNull(message = "{user.officeAddress.must}")
	@Size(max = 200, message = "{user.officeAddress.invalid}")
	private String officeAddress;
	
	@NotNull(message = "{user.personalIdentificationNumber.must}")
	@Max(value = 999999999999l, message = "{user.personalIdentificationNumber.invalid}")
	@Min(value = 100000000000l, message = "{user.personalIdentificationNumber.invalid}")
	private Long personalIdentificationNumber;

	
	
	public UserProfileDTO() {
		super();
	}

	public UserProfileDTO(UserProfileEntity userEntity) {
		setUserId(userEntity.getUserId());
		setFirstName(userEntity.getFirstName());
		setLastName(userEntity.getLastName());
		setEmailId(userEntity.getEmailId());
		setMobileNumber(userEntity.getMobileNumber());
		setPassword(userEntity.getPassword());
		setNationality(userEntity.getNationality());
		setPassportNumber(userEntity.getPassportNumber());
		setPermanentAddress(userEntity.getPermanentAddress());
		setOfficeAddress(userEntity.getOfficeAddress());
		setPersonalIdentificationNumber(userEntity.getPersonalIdentificationNumber());
	}

	public static UserProfileEntity prepareEntity(UserProfileDTO userDto)
	{
		return new UserProfileEntity(userDto);
	}
	@Override
	public String toString() {
		return "UserProfileDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + ", nationality=" + nationality
				+ ", passportNumber=" + passportNumber + ", permanentAddress=" + permanentAddress + ", officeAddress="
				+ officeAddress + ", personalIdentificationNumber=" + personalIdentificationNumber + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
