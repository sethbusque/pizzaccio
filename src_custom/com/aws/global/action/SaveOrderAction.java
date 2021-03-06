package com.aws.global.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Order;
import com.aws.global.classes.Pizza;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.OrderServiceImpl;
import com.aws.global.serviceImpl.PizzaServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class SaveOrderAction extends BaseActionSupport {
	//Autowired Variables
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderServiceImpl orderServiceImpl;
	
	@Autowired
	@Qualifier("order")
	private Order order;
	
	//Other Variables
	private ArrayList<Pizza> pizzas;
	
	//Actions
	@Action(value="saveOrder", results ={
		@Result(name=ActionSupport.SUCCESS, location="goToAddOrder", type="redirect", params = {"success", "true"}),
		@Result(name=ActionSupport.INPUT, location="pages/addOrder.jsp"),
	})
	public String SaveOrder(){
		pizzas = pizzaServiceImpl.getAllPizza();
		orderServiceImpl.addOrder(order);
		System.out.println("Save Order");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		pizzas = pizzaServiceImpl.getAllPizza();
		if(order.getPizzaId()==-1){
			addFieldError("order.pizzaId", getText("error.common.pizzaname.required"));
		}
		if(order.getQuantity()<1){
			addFieldError("order.quantity", getText("error.common.quantity.required"));
		}
		System.out.println(order.isDineType());
	}
	
	/**
	 * @return the pizzas
	 */
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	/**
	 * @return the pizzaServiceImpl
	 */
	public PizzaServiceImpl getPizzaServiceImpl() {
		return pizzaServiceImpl;
	}

	/**
	 * @param pizzaServiceImpl the pizzaServiceImpl to set
	 */
	public void setPizzaServiceImpl(PizzaServiceImpl pizzaServiceImpl) {
		this.pizzaServiceImpl = pizzaServiceImpl;
	}

	/**
	 * @return the orderServiceImpl
	 */
	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	/**
	 * @param orderServiceImpl the orderServiceImpl to set
	 */
	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
}
