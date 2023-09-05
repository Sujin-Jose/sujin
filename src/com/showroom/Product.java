package com.showroom;


import java.sql.*;
	import java.util.*;
	public class Product {
		static String databaseUrl = "jdbc:mysql://localhost:3306/vehicleshowroom";
		static String username = "root";
		static String password = "12345";

		public static void createTable() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(databaseUrl, username, password);
			Statement st = con.createStatement();
			String query = "insert into product(product_name,category_id,vendor_id,price,quantity,product_description) values ('Ford Mustang 1984','2','1','4000000','1','The 1984 Ford Mustang was part of the third generation of the Mustang, which Ford produced from 1979 to 1993. This generation represented a significant departure from the previous models, as it introduced a smaller and more fuel-efficient design.')";
			st.executeUpdate(query);
		}

		public static void readTable() throws ClassNotFoundException,SQLException{	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(databaseUrl,username,password);
			Statement st=con.createStatement();
			String query="select * from product";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				String productId=rs.getString("product_id");
				String vendorId=rs.getString("vendor_id");
				String price=rs.getString("price");
				String categoryId=rs.getString("category_id");
				String quantity=rs.getString("quantity");
				String productName=rs.getString("product_name");
				String productDescription=rs.getString("product_description");
				System.out.println(productId+" "+productName+" "+categoryId +" "+vendorId+" "+price+" "+quantity+" "+productDescription+ "\n");
			}
		}

		public static void updateTable() throws ClassNotFoundException,SQLException{	
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(databaseUrl,username,password);
			Statement st=con.createStatement();
			String query="update product set product_Id=3 where product_Id=4 ";
			st.executeUpdate(query);
		}

		public static void deleteTable() throws ClassNotFoundException,SQLException{	
					
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(databaseUrl,username,password);
			Statement st=con.createStatement();
			String query="delete from product where category_id= 2  ";
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


