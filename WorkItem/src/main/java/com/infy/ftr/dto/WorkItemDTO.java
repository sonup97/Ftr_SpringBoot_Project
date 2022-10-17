package com.infy.ftr.dto;

 
import java.util.Date;
 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
 

public class WorkItemDTO {
	
	@NotNull(message = "{workitem.userId.must}")
	@Size(min = 1, max = 5, message = "{workitem.userId.invalid}")
	private String workItemId;
	
	
	private Long userId;
	
	@NotNull(message = "{workitem.itemName.must}")
	@Size(min = 3, max = 25, message = "{workitem.itemName.invalid}")
	private String itemName;
 
	@NotNull(message = "{workitem.itemType.must}")
	@Size(min = 4, max = 25, message = "{workitem.itemType.invalid}")
	private String itemType;
	
	@NotNull(message = "{workitem.itemDescription.must}")
	@Size(min = 10, max = 45, message = "{workitem.itemDescription.invalid}")
	private String itemDescription;
	
	@NotNull(message = "{workitem.messageToRecipient.must}")
	@Size(min = 10, max = 50, message = "{workitem.messageToRecipient.invalid }")
	private String messageToRecipient;
	
	@NotNull(message = "{workitem.quantity.must}")
	private String quantity;
	@NotNull(message = "{workitem.sourceCountry.must}")
	@Size(min = 5, max = 25, message = "{workitem.sourceCountry.invalid }")
	private String sourceCountry;
	@NotNull(message = "{workitem.destinationCountry.must}")
	@Size(min = 5, max = 25, message = "{workitem.destinationCountry.invalid}")
	private String destinationCountry;
	private String OriginHarborLocations;
	@NotNull(message = "{workitem.selectedHarborLocation.must}")
	@Size(min = 5, max = 25, message = "{workitem.selectedHarborLocation.invalid}")
	private String SelectedHarborLocations;
	
	@NotNull(message = "{workitem.shippingDate.must}")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
//	@Future(message = "{workitem.shippingDate.invalid}")
	private Date shippingDate;
	private Integer amount;
	
	public String getWorkItemId() {
		return workItemId;
	}
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getMessageToRecipient() {
		return messageToRecipient;
	}
	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSourceCountry() {
		return sourceCountry;
	}
	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public String getOriginHarborLocations() {
		return OriginHarborLocations;
	}
	public void setOriginHarborLocations(String originHarborLocations) {
		OriginHarborLocations = originHarborLocations;
	}
	public String getSelectedHarborLocations() {
		return SelectedHarborLocations;
	}
	public void setSelectedHarborLocations(String selectedHarborLocations) {
		SelectedHarborLocations = selectedHarborLocations;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
