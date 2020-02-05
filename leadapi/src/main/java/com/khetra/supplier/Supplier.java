package com.khetra.supplier;

//import javax.xml.bind.annotation.XmlRootElement;
import javax.json.bind.annotation.*;
//@XmlRootElement
@JsonbAnnotation

public class Supplier {
	private int U_ID;
	private String name;
	private String address;
	private String list;
	private String city;
	private String state;
	private String zip;
	private String mobile;
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int U_ID) {
		this.U_ID = U_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Supplier [U_ID=" + U_ID + ", name=" + name + ", address=" + address + ", list=" + list + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", mobile=" + mobile + "]";
	}
	
	

}