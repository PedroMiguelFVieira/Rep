package com.multicert.manager;

import java.util.List;

import com.multicert.bean.Car;

/**
 * Manages access to car information. Used as the service layer component in
 * the <tt>mvc</tt> and <tt>security</tt> projects.
 */
public interface ICarManager {


	public List<Car> getAllCars();


	public Car getCar(Long id);


	public Car save(Car car);


	public void update(Car car);


}
