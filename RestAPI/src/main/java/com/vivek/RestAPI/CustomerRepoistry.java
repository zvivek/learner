package com.vivek.RestAPI;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import java.net.ConnectException;
import java.sql.*;
public class CustomerRepoistry {
List<Customer> customers;Connection con=null;

public CustomerRepoistry(){/*
	customers=new ArrayList<>();
	Customer c1=new Customer();
	c1.setCustomerId(1);
	c1.setName("Vivek");
	Customer c2=new Customer();
	c2.setCustomerId(2);
	c2.setName("Singh");
	customers.add(c1);
	customers.add(c2);
	*/
	
	String url="jdbc:mysql://localhost:3306/restdb";
	String username="root";
	String password="root";
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public List<Customer> getCustomers(){
	List<Customer> cust=new ArrayList<Customer>();
	String sql="select * from customer";
	
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			Customer c=new Customer();
			c.setCustomerId(rs.getInt(1));
			c.setName(rs.getString(2));
			cust.add(c);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cust;
	
}
public Customer getCustomer(Integer id)
{
	String sql="select * from customer where CustomerId="+id;
	Customer c=new Customer();
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			
			c.setCustomerId(rs.getInt(1));
			c.setName(rs.getString(2));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return c;
	}

public void create(Customer c1) {
	String sql="Insert into customer values(?,?)";
	try{
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, c1.getCustomerId());
		st.setString(2,c1.getName());
		st.executeUpdate();
		
	}catch(Exception e){}
}
}
