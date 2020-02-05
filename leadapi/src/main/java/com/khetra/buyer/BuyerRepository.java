package com.khetra.buyer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BuyerRepository {
	
	Connection con=null;
	public BuyerRepository()
	{
		String url="jdbc:mysql://localhost:3306/khetra_db";
		String username="rajeev";
		String password="rajeev_@1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	
	public List<Buyer> getBuyers(){
		List<Buyer> buyers =new ArrayList<>();
		String sql="select * from demand_registration";
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Buyer a=new Buyer();
			a.setU_ID(rs.getInt(1));
			a.setBtype(rs.getString(2));
			a.setLic_no(rs.getString(3));
			a.setO_name(rs.getString(4));
			a.setMobile(rs.getString(5));
			a.setShop_name(rs.getString(6));
			a.setShop_address(rs.getString(7));
			a.setPin(rs.getString(8));
			a.setCity(rs.getString(9));
			a.setDelivery(rs.getString(10));
			a.setPan(rs.getString(11));
			a.setAadhar(rs.getString(12));
			a.setBank_acc(rs.getString(13));
			a.setIfsc(rs.getString(14));
			a.setGst(rs.getString(15));
			buyers.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return buyers;
	}
	public Buyer getBuyer(int U_ID){
		String sql="select * from demand_registration where U_ID="+U_ID;
		Buyer a=new Buyer();
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{	a.setU_ID(rs.getInt(1));
			a.setBtype(rs.getString(2));
			a.setLic_no(rs.getString(3));
			a.setO_name(rs.getString(4));
			a.setMobile(rs.getString(5));
			a.setShop_name(rs.getString(6));
			a.setShop_address(rs.getString(7));
			a.setPin(rs.getString(8));
			a.setCity(rs.getString(9));
			a.setDelivery(rs.getString(10));
			a.setPan(rs.getString(11));
			a.setAadhar(rs.getString(12));
			a.setBank_acc(rs.getString(13));
			a.setIfsc(rs.getString(14));
			a.setGst(rs.getString(15));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	public void create(Buyer a1) {
		String sql="insert into demand_registration(U_ID,btype,lic_no,o_name,mobile,shop_name,shop_address,pin,city,delivery,pan,aadhar,bank_acc,ifsc,gst) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,a1.getU_ID());
		st.setString(2, a1.getBtype());
		st.setString(3, a1.getLic_no());
		st.setString(4, a1.getO_name());
		st.setString(5, a1.getMobile());
		st.setString(6, a1.getShop_name());
		st.setString(7, a1.getShop_address());
		st.setString(8, a1.getPin());
		st.setString(9, a1.getCity());
		st.setString(10,a1.getDelivery());
		st.setString(11,a1.getPan());
		st.setString(12,a1.getAadhar());
		st.setString(13,a1.getBank_acc());
		st.setString(14, a1.getIfsc());
		st.setString(15,a1.getGst());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update(Buyer a1) {
		String sql="update demand_registration set btype=?,lic_no=?,o_name=?,mobile=?,shop_name=?,shop_address=?,pin=?,city=?,delivery=?,pan=?,aadhar=?,bank_acc=?,ifsc=?,gst=? where U_ID=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, a1.getBtype());
		st.setString(2, a1.getLic_no());
		st.setString(3, a1.getO_name());
		st.setString(4, a1.getMobile());
		st.setString(5, a1.getShop_name());
		st.setString(6, a1.getShop_address());
		st.setString(7, a1.getPin());
		st.setString(8, a1.getCity());
		st.setString(9, a1.getDelivery());
		st.setString(10,a1.getPan());
		st.setString(11,a1.getAadhar());
		st.setString(12,a1.getBank_acc());
		st.setString(13, a1.getIfsc());
		st.setString(14,a1.getGst());
		st.setInt(15,a1.getU_ID());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void delete(int U_ID) {
		String sql="delete from demand_registration where U_ID=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, U_ID);
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}