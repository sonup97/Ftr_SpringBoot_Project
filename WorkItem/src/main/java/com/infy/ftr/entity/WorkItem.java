package com.infy.ftr.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_workitems")
public class WorkItem {

	@Id
	@Column(name="workitem_id")
	private String workItemId;
	private Long userId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String messageToRecipient;
	private String quantity;
//	@Column(name="collection_country")
	private String sourceCountry;
	private String destinationCountry;
	private String OriginHarborLocations;
	private String SelectedHarborLocations;
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
