package com.multicert.bean;

public class Car{


	
	private Long id;
	private String model;
	private String licensePlate;
	private String brand;
	private String averageConsumption;
	
	
	public Car (Long id, String model, String licensePlate, String brand, String averageConsumption) {
		super();
		this.id = id;
		this.model = model;
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.averageConsumption = averageConsumption;		
	}
	
	public Car(String model, String licencePlate, String brand, String averageConsumption) {
		super();		
		this.model = model;
		this.licensePlate = licencePlate;
		this.brand = brand;
		this.averageConsumption = averageConsumption;	
	}
	
	
	 public Car() {
	        super();
	    }
	 
	 
	 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getAverageConsumption() {
		return averageConsumption;
	}
	public void setAverageConsumption(String averageConsumption) {
		this.averageConsumption = averageConsumption;
	}
	
	 public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
    public String toString() {		 
        return String.format("Car [model=%s, licencePlate=%s, brand=%s , averageConsumption=%s]", model, licensePlate, brand, averageConsumption);
    }	
	
	
	
	
}
