package com.khetra.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LeadRepository {
	
	Connection con=null;
	public LeadRepository()
	{
		String url="jdbc:mysql://34.93.191.88:3306/khetra_db";
		String username="rajeev";
		String password="rajeev_@1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	
	public List<Lead> getLeads(){
		List<Lead> leads =new ArrayList<>();
		String sql="select * from LMS";
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Lead a=new Lead();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setMobile_no(rs.getString(3));
			a.setLead_type(rs.getString(4));
			a.setPin_code(rs.getString(5));		
			leads.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return leads;
	}
	public Lead getLead(int id){
		String sql="select * from LMS where id="+id;
		Lead a=new Lead();
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{	a.setId(rs.getInt(1));		
			a.setName(rs.getString(2));
			a.setMobile_no(rs.getString(3));
			a.setLead_type(rs.getString(4));
			a.setPin_code(rs.getString(5));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	public void create(Lead a1) {
		String sql="insert into LMS(id,name,mobile_no,lead_type,pin_code) values (?,?,?,?,?)";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,a1.getId());
		st.setString(2, a1.getName());
		st.setString(3, a1.getMobile_no());
		st.setString(4, a1.getLead_type());
		st.setString(5, a1.getPin_code());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update(Lead a1) {
		String sql="update LMS set name=?,mobile_no=?,lead_type=?,pin_code=? where id=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, a1.getName());
		st.setString(2, a1.getMobile_no());
		st.setString(3, a1.getLead_type());
		st.setString(4, a1.getPin_code());
		st.setInt(5,a1.getId());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql="delete from LMS where id=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}