package com.cminsurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cminsurance.model.Customer;

public class DBController {
	private EntityManagerFactory factory = null;
	private EntityManager em = null;

	public DBController() {
		factory = Persistence.createEntityManagerFactory("unit_app");
		em = factory.createEntityManager();
	}
	
	public Integer saveCustomer(Customer customer) {
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return 10;
		}
		return 0;
	}

	public List<Customer> searchAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		//em.find(Customer.class, null);
		List<Customer> resultList = em.createQuery("select e from Customer e").getResultList();
		return resultList;
	}
}
