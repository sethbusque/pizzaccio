package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Order;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class GoToViewOrder extends BaseActionSupport{
	//Autowired Variables
	@Autowired
	@Qualifier("order")
	private Order order;
			
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderServiceImpl orderServiceImpl;

	//Other Variables
	private List<Order> orders;
		
	//When User Chooses View Order Option in the navbar
	@Action(value="goToViewOrder", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewOrder.jsp")
	})
	public String gotoViewOrder() {
		setOrders(orderServiceImpl.getAllOrder());
		System.out.println("Redirecting to View Order Page");
		return ActionSupport.SUCCESS;
	}
	
	//Getter and Setter for each Variable
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
