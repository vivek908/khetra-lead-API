package com.khetra.buyer;

//import javax.xml.bind.annotation.XmlRootElement;
import javax.json.bind.annotation.*;
//@XmlRootElement
@JsonbAnnotation
public class Buyer {
	private int U_ID;
	private String btype;
	private String lic_no;
	private String o_name;
	private String mobile;
	private String shop_name;
	private String shop_address;
	private String pin;
	private String city;
	private String delivery;
	private String pan;
	private String aadhar;
	private String bank_acc;
	private String ifsc;
	private String gst;
	
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int U_ID) {
		this.U_ID = U_ID;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getLic_no() {
		return lic_no;
	}
	public void setLic_no(String lic_no) {
		this.lic_no = lic_no;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getBank_acc() {
		return bank_acc;
	}
	public void setBank_acc(String bank_acc) {
		this.bank_acc = bank_acc;
	}
	
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Buyer [U_ID=" + U_ID + ", btype=" + btype + ", lic_no=" + lic_no + ", o_name=" + o_name + ", mobile="
				+ mobile + ", shop_name=" + shop_name + ", shop_address=" + shop_address + ", pin=" + pin + ", city="
				+ city + ", delivery=" + delivery + ", pan=" + pan + ", aadhar=" + aadhar + ", bank_acc=" + bank_acc
				+ ", ifsc=" + ifsc + ", gst=" + gst + "]";
	}
	
}
