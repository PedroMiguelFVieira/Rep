package com.multicert.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multicert.bean.Car;


/**
 * An car manager that uses Hibernate to find cars.
 */
@Service
public class CarManager implements ICarManager {

	//@PersistenceUnit(unitName = "test")
	
	private EntityManager entityManager;

	public CarManager() {
		Logger.getLogger(CarManager.class).info("Created JpaCarManager");
	}

	/**
	 * Creates a new JPA car manager.
	 * 
	 * @param entityManager
	 *            the JPA entity manager
	 */
	public CarManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PersistenceContext(unitName="test", type=PersistenceContextType.EXTENDED)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		System.out.println("inside get all");
		
		List<Car> l = entityManager.createQuery("select c from Car c").getResultList();

		List<Car> result = new ArrayList<Car>();

		for (Car a : l) {
			if (!result.contains(a))
				result.add(a);
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Car getCar(Long id) {
		Car car = (Car) entityManager.find(Car.class, id);

		return car;
	}

	@Override
	@Transactional
	public Car save(Car car) {
		entityManager.persist(car);
		return car;
	}

	@Override
	@Transactional
	public void update(Car car) {
		entityManager.merge(car);
	}

	

}
