package cn.jxufe.db.domain;

import java.util.Date;

public class ordermaster {
	private String orderno;
	private Date ordertime;
	private int money;
	private int ticketsum;
	private String orderstatus;
	private user user;// 对应该订单的user
	private flightclass flightclass;// 对应该订单的航班班次（航班信息在航班班次中）

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}


	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public flightclass getFlightclass() {
		return flightclass;
	}

	public void setFlightclass(flightclass flightclass) {
		this.flightclass = flightclass;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTicketsum() {
		return ticketsum;
	}

	public void setTicketsum(int ticketsum) {
		this.ticketsum = ticketsum;
	}
}
