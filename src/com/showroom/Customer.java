package com.showroom;

import java.sql.*;
import java.util.*;
public class Customer {
	static String databaseUrl = "jdbc:mysql://localhost:3306/vehicleshowroom";
	static String username = "root";
	static String password = "12345";

	public static void createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(databaseUrl, username, password);
		Statement st = con.createStatement();
		String query = "insert into customer(customer_name,email,phone_number) values ('Shafeek','shafeek@gmail',9876543),('Bravin','bravin@gmail',976431852),('Anon','anon@gmail',963852741),('Afrudheen','afrudheen@gmail',951847623),('Shankar','shankar@gmail',852741963),('Mariya','mariya@gmail',741963741),('Sharanya','sharanya@gmail',852963741)";
		st.executeUpdate(query);
	}

	public static void readTable() throws ClassNotFoundException,SQLException{	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="select * from customer";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			String customerName=rs.getString("customer_name");
			String customerId=rs.getString("customer_id");
			String email=rs.getString("email");
			String phoneNumber=rs.getString("phone_number");
			System.out.println(customerId +" "+ customerName+" "+email+ " "+phoneNumber );
		}
	}

	public static void updateTable() throws ClassNotFoundException,SQLException{	
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="update customer set customer_name='Afrudeen' where customer_name= 'Afrudheen' ";
		st.executeUpdate(query);
	}

	public static void deleteTable() throws ClassNotFoundException,SQLException{	
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="delete from customer where categor_name='Anon'  ";
		st.executeUpdate(query);
	}
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Scanner sc=new Scanner(System.in);
		int i=1;
		while(i==1)
		{
		System.out.println("Choose the operation"+"\n"+"1. Create Table"+"\n"+"2. Read Table"+"\n"+"3. Update table"+"\n"+"4. Delete Table");
		int n=sc.nextInt();
		switch(n){
		case 1:
			createTable();
			break;
		case 2:
			readTable();
			break;
		case 3:
			updateTable();
			break;
		case 4:
			deleteTable();
			break;
		default:
			System.out.println("Invalid Input");
			
		}
	}
}
}


