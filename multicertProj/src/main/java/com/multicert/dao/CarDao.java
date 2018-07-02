package com.multicert.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.multicert.bean.Car;

public class CarDao {
	
  // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/test";  
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = ""; 

	public CarDao() {
		
	}
	
	public void printValues() throws SQLException, ClassNotFoundException {
		
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);  
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from CAR");
		
		while (rs.next()) {
			System.out.println(rs.getString("MODEL") + rs.getString("LICENSE_PLATE") + rs.getString("BRAND") + rs.getString("AVERAGE_CONSUMPTION"));
			
		}
		
		  stmt.close(); 
		  con.close();
		
	}
	
	
	
	
	public void insertCar(Car car) throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);  
		
		
		
		 String model  = car.getModel();
		 String licensePlate = car.getLicencePlate();
		 String brand = car.getBrand();
		 String averageConsumption = car.getAverageConsumption();

		 PreparedStatement pstmt = con.prepareStatement("INSERT INTO Car (MODEL, LICENSE_PLATE, BRAND, AVERAGE_CONSUMPTION) " 
			     +"VALUES (?,?,?,?)");
			pstmt.setString(1,model);
			pstmt.setString(2,licensePlate);
			pstmt.setString(3,brand);
			pstmt.setString(4,averageConsumption);
			pstmt.executeUpdate();		
			
			pstmt.close(); 
			  con.close();
	}
	
	
	public void deleteCar(String licensePlate) throws ClassNotFoundException, SQLException {
		
		
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);  
		
		
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM CAR WHERE LICENSE_PLATE = ?");
		pstmt.setString(1,licensePlate);
		pstmt.executeUpdate();
	
		pstmt.close(); 
		con.close();
		
	}
	
	public Car getCarByPlate(String licensePlate) throws ClassNotFoundException, SQLException {
		
		
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);  
		
		
		PreparedStatement pstmt = con.prepareStatement("Select * from CAR WHERE LICENSE_PLATE = ?");
		pstmt.setString(1,licensePlate);
		ResultSet rs = pstmt.executeQuery();
		
				
		if(rs!=null) {
			Car car = new Car();
			car.setModel(rs.getString("MODEL"));
			car.setLicencePlate(rs.getString("LICENSE_PLATE"));
			car.setBrand(rs.getString("BRAND"));
			car.setAverageConsumption(rs.getString("AVERAGE_CONSUMPTION"));
			
			pstmt.close(); 
			con.close();
			
			return car;
		}
		
		 pstmt.close(); 
		 con.close();
		 return null;
		
		 
	}
	
	
	
	public List<Car> getAll() throws SQLException, ClassNotFoundException {
		
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL,USER,PASS);  
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from CAR");
		List <Car> cars = new LinkedList<Car>();
		
		while (rs.next()) {
			
			Car car = new Car();
			car.setId(rs.getLong("ID"));
			car.setModel(rs.getString("MODEL"));
			car.setLicencePlate(rs.getString("LICENSE_PLATE"));
			car.setBrand(rs.getString("BRAND"));
			car.setAverageConsumption(rs.getString("AVERAGE_CONSUMPTION"));
			cars.add(car);
			
			
		}
		
		stmt.close(); 
		con.close();
		return cars;
		
	}
	
	
	
}
