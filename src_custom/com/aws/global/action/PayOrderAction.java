package com.aws.global.action;

import java.util.ArrayList;
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
public class PayOrderAction extends BaseActionSupport{
	
	//Autowired variables
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderServiceImpl orderServiceImpl;

	@Autowired
	@Qualifier("order")
	private Order order;

	//Other variables
	private List<Integer> orderId;

	private List<Order> orders;
	
	private int totalPayment;

	//Actions
	@Action(value="payOrder", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/paymentForm.jsp"),
			@Result(name=ActionSupport.INPUT, location="pages/viewOrder.jsp"),
	})
	public String PayOrder(){
		
		List<Order> ordersTemp = new ArrayList<Order>();
		for(int i=0; i< orderId.size(); i++){
			ordersTemp.add(orderServiceImpl.getOrderById(orderId.get(i)));
			setTotalPayment(getTotalPayment()+ordersTemp.get(i).getSubTotal());
		}
		setOrders(ordersTemp);
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if(getOrderId()==null){
			setOrders(orderServiceImpl.getAllOrder());
			if (orders.isEmpty()) orders = null;
			System.out.println("Redirecting to View Order Page with Error");
			addFieldError("checkAll", "Please choose a pizza to pay");
		}
	}
	
	//Getter and Setters for each variables
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Integer> getOrderId() {
		return orderId;
	}

	public void setOrderId(List<Integer> orderId) {
		this.orderId = orderId;
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
	
	public int getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
}




