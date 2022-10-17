package com.tm1.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.tm1.entity.Terminal;

public class TerminalDTO {
	
private String terminalId;
	
	@NotNull(message = "{terminal.terminalName.must}")
	@Length(min = 3, max = 20, message = "{terminal.terminalName.invalid}")
	private String terminalName;

	@NotNull(message = "{terminal.country.must}")
	@Length(min = 3, max = 20, message = "{terminal.country.invalid}")
	private String country;

	@NotNull(message = "{terminal.itemType.must}")
	@Length(min = 4, max = 30, message = "{terminal.itemType.invalid}")
	private String itemType;

	@NotNull(message = "{terminal.terminalDescription.must}")
	@Pattern(regexp = "^T[0-9]{1,3}[-][a-zA-Z\\s]+$", message = "{terminal.terminalDescription.invalid}")
	@Length(max = 25, message = "{terminal.terminalDescriptionLength.invalid}")
	private String terminalDescription;

	@NotNull(message = "{terminal.capacity.must}")
	@Max(value = 99999, message = "{terminal.capacity.invalid}")
	private Integer capacity;

	@NotNull(message = "{terminal.status.must}")
	@Pattern(regexp = "^(Available|NotAvailable)$", message = "{terminal.status.invalid}")
	private String status;

	@NotNull(message = "{terminal.harborLocation.must}")
	@Length(min = 5, max = 25, message = "{terminal.harborLocation.invalid}")
	private String harborLocation;
	
	@NotNull(message = "{terminal.availableCapacity.must}")
	@Max(value = 99999, message = "{terminal.availableCapacity.invalid}")
	private Integer availableCapacity;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTerminalDescription() {
		return terminalDescription;
	}

	public void setTerminalDescription(String terminalDescription) {
		this.terminalDescription = terminalDescription;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAvailableCapacity() {
		return availableCapacity;
	}

	public void setAvailableCapacity(Integer availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	public static Terminal prepareTerminal(TerminalDTO t) {
		Terminal t1 = new Terminal();
		BeanUtils.copyProperties(t, t1);
		return t1;
		
	}
}
