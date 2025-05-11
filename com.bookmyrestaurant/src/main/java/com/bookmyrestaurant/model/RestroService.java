package com.bookmyrestaurant.model;

public class RestroService {

	private int serviceId;
	private String serviceIcon;
	private String serviceName;
	private String serviceDescription;
	private String datetime;	
	
	public RestroService() {
		super();
	}
	public RestroService(int serviceId, String serviceIcon, String serviceName, String serviceDescription,String datetime) {
		super();
		this.serviceId = serviceId;
		this.serviceIcon = serviceIcon;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.setDatetime(datetime);
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceIcon() {
		return serviceIcon;
	}
	public void setServiceIcon(String serviceIcon) {
		this.serviceIcon = serviceIcon;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "RestroService [serviceId=" + serviceId + ", serviceIcon=" + serviceIcon + ", serviceName=" + serviceName
				+ ", serviceDescription=" + serviceDescription + ", datetime=" + datetime + "]";
	}
	
	
	
}
