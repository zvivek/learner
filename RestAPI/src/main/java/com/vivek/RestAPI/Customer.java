package com.vivek.RestAPI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	private Integer CustomerId;
	@Override
	public String toString() {
		return "Customer [name=" + name + ", CustomerId=" + CustomerId + "]";
	}
	

}
