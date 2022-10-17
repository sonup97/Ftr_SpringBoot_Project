package com.tm1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import com.tm1.dto.TerminalDTO;

@Entity	
@Table(name="ftr_terminals")
public class Terminal {
	@Id
	@GenericGenerator (strategy = "com.tm1.utility.TerminalIDGenerator", name = "terminalidgenerator")
	@GeneratedValue(generator = "terminalidgenerator")
	private String terminalId;
	private String terminalName;
	private String country;
	private String itemType;
	private String terminalDescription;
	
	private int capacity;
	private String status;
	private String harborLocation;
//	@Transient
	private int availableCapacity;
	
	
	
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	public int getAvailableCapacity() {
		return availableCapacity;
	}
	public void setAvailableCapacity(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}
	public static TerminalDTO prepareTerminalDTO(Terminal t) {
		TerminalDTO t1 = new TerminalDTO();
		BeanUtils.copyProperties(t, t1);
		return t1;
}
}
