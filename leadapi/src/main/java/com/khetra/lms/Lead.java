package com.khetra.lms;

//import javax.xml.bind.annotation.XmlRootElement;
import javax.json.bind.annotation.*;
//@XmlRootElement
@JsonbAnnotation
public class Lead {
	private int id;
	private String name;
	private String mobile_no;
	private String lead_type;
	private String pin_code;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getLead_type() {
		return lead_type;
	}
	public void setLead_type(String lead_type) {
		this.lead_type = lead_type;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	@Override
	public String toString() {
		return "Lead [id=" + id + ", name=" + name + ", mobile_no=" + mobile_no + ", lead_type=" + lead_type
				+ ", pin_code=" + pin_code + "]";
	}
	
	
}
