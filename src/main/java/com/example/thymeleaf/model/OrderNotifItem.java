package com.example.thymeleaf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblordernotifications")
public class OrderNotifItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationReasonId;
	private String notificationReasonCode;
	public Integer getNotificationReasonId() {
		return notificationReasonId;
	}
	public void setNotificationReasonId(Integer notificationReasonId) {
		this.notificationReasonId = notificationReasonId;
	}
	public String getNotificationReasonCode() {
		return notificationReasonCode;
	}
	public void setNotificationReasonCode(String notificationReasonCode) {
		this.notificationReasonCode = notificationReasonCode;
	}
	@Override
	public String toString() {
		return "Shop [notificationReasonId=" + notificationReasonId + ", notificationReasonCode="
				+ notificationReasonCode + "]";
	}
	
	
	
	
	
	
	

}
