package com.showroom;
import java.sql.*;
import java.util.*;
public class Category {
	static String databaseUrl = "jdbc:mysql://localhost:3306/vehicleshowroom";
	static String username = "root";
	static String password = "12345";

	public static void createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(databaseUrl, username, password);
		Statement st = con.createStatement();
		String query = "insert into category(category_name) values ('4 wheeler')";
		st.executeUpdate(query);
	}

	public static void readTable() throws ClassNotFoundException,SQLException{	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="select * from category";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			String categoryName=rs.getString("category_name");
			String categoryId=rs.getString("category_id");
			System.out.println(categoryId +" "+ categoryName );
		}
	}

	public static void updateTable() throws ClassNotFoundException,SQLException{	
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="update category set category_id=2 where category_id= 4 ";
		st.executeUpdate(query);
	}

	public static void deleteTable() throws ClassNotFoundException,SQLException{	
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(databaseUrl,username,password);
		Statement st=con.createStatement();
		String query="delete from category where category_id= 3  ";
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

