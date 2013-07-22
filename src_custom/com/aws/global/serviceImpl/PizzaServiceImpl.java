package com.aws.global.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.dao.PizzaDAO;
import com.aws.global.service.PizzaService;

public class PizzaServiceImpl implements PizzaService{

	//Autowired variables
	@Autowired
	@Qualifier("pizzaDAO")
	private PizzaDAO pizzaDAO;
	
	//Overrided methods from PizzaService
	@Override
	public void addPizza(String pizzaName, int pizzaPrice) {
		// TODO Auto-generated method stub
		pizzaDAO.addPizza(pizzaName, pizzaPrice);
	}

}