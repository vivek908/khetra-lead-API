package com.khetra.supplier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SupplierRepository {
	
	Connection con=null;
	public SupplierRepository()
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
	
	public List<Supplier> getSuppliers(){
		List<Supplier> suppliers =new ArrayList<>();
		String sql="select * from supplier_reg";
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Supplier a=new Supplier();
			a.setU_ID(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setAddress(rs.getString(3));
			a.setList(rs.getString(4));
			a.setCity(rs.getString(5));	
			a.setState(rs.getString(6));
			a.setZip(rs.getString(7));
			a.setMobile(rs.getString(8));
			
			suppliers.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return suppliers;
	}
	public Supplier getSupplier(int U_ID){
		String sql="select * from supplier_reg where U_ID="+U_ID;
		Supplier a=new Supplier();
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{	a.setU_ID(rs.getInt(1));		
			a.setName(rs.getString(2));
			a.setAddress(rs.getString(3));
			a.setList(rs.getString(4));
			a.setCity(rs.getString(5));
			a.setState(rs.getString(6));
			a.setZip(rs.getString(7));
			a.setMobile(rs.getString(8));
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	public void create(Supplier a1) {
		String sql="insert into supplier_reg(U_ID,name,address,list,city,state,zip,mobile) values (?,?,?,?,?,?,?,?)";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,a1.getU_ID());
		st.setString(2, a1.getName());
		st.setString(3, a1.getAddress());
		st.setString(4, a1.getList());
		st.setString(5, a1.getCity());
		st.setString(6, a1.getState());
		st.setString(7, a1.getZip());
		st.setString(8, a1.getMobile());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update(Supplier a1) {
		String sql="update supplier_reg set name=?,address=?,list=?,city=?,state=?,zip=?,mobile=? where U_ID=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, a1.getName());
		st.setString(2, a1.getAddress());
		st.setString(3, a1.getList());
		st.setString(4, a1.getCity());
		st.setString(5, a1.getState());
		st.setString(6, a1.getZip());
		st.setString(7, a1.getMobile());
		st.setInt(8,a1.getU_ID());
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void delete(int U_ID) {
		String sql="delete from supplier_reg where U_ID=?";
		try
		{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,U_ID);
		st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}