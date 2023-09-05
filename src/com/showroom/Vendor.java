package com.showroom;

import java.sql.*;
import java.util.*;
public class Vendor {
	static String databaseUrl = "jdbc:mysql://localhost:3306/vehicleshowroom";
	static String username = "root";
	static String password = "12345";

	public static void createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(databaseUrl, username, password);
		Statement st = con.createStatement();
		String query = "insert into vendor(vendor_name,email,phone_number) values ('Rahman','rahman@gmail',9876543),('Sujin','sujin@gmail',976431852),('Bianco','bianco@gmail',963852741),('Nivas','nivas@gmail',951847623),('Gowri','gowri@gmail',852741963)";
		st.executeUpdate(query);
	}

	public static void readTable() throws ClassNotFoundException,SQLException{	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="select * from vendor";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			String vendorName=rs.getString("vendor_name");
			String vendorId=rs.getString("vendor_id");
			String email=rs.getString("email");
			String phoneNumber=rs.getString("phone_number");
			System.out.println(vendorId +" "+ vendorName+" "+email+ " "+phoneNumber );
		}
	}

	public static void updateTable() throws ClassNotFoundException,SQLException{	
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="update vendor set vendor_name='Jose' where vendor_name = 'Sujin'";
		st.executeUpdate(query);
	}

	public static void deleteTable() throws ClassNotFoundException,SQLException{	
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="delete from vendor where vendor_id= 3  ";
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
