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

	public CarDao() {
		
	}
	
	public void printValues() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from CAR");
		
		while (rs.next()) {
			System.out.println(rs.getString("MODEL") + rs.getString("LICENSE_PLATE") + rs.getString("BRAND") + rs.getString("AVERAGE_CONSUMPTION"));
			
		}
		
	}
	
	
	public void insertCar(Car car) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		
		
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
	}
	
	
	public void deleteCar(String licensePlate) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM CAR WHERE LICENSE_PLATE = ?");
		pstmt.setString(1,licensePlate);
		pstmt.executeUpdate();
	
		
	}
	
	public Car getCarByPlate(String licensePlate) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		
		PreparedStatement pstmt = con.prepareStatement("Select * from CAR WHERE LICENSE_PLATE = ?");
		pstmt.setString(1,licensePlate);
		ResultSet rs = pstmt.executeQuery();
		
				
		if(rs!=null) {
			Car car = new Car();
			car.setModel(rs.getString("MODEL"));
			car.setLicencePlate(rs.getString("LICENSE_PLATE"));
			car.setBrand(rs.getString("BRAND"));
			car.setAverageConsumption(rs.getString("AVERAGE_CONSUMPTION"));
			return car;
		}
		
		 return null;
		
		
	}
	
	
	
	public List<Car> getAll() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from CAR");
		List <Car> cars = new LinkedList<Car>();
		
		while (rs.next()) {
			
			Car car = new Car();
			car.setModel(rs.getString("MODEL"));
			car.setLicencePlate(rs.getString("LICENSE_PLATE"));
			car.setBrand(rs.getString("BRAND"));
			car.setAverageConsumption(rs.getString("AVERAGE_CONSUMPTION"));
			cars.add(car);
			
			
		}
		
		
		return cars;
		
	}
	
	
	
}
