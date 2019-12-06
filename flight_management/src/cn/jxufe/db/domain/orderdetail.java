package cn.jxufe.db.domain;

public class orderdetail {
	private ordermaster order;// 对应所属主订单
	private String detailsno;
	private int ticketprice;
	private String ticketstatus;
	// 飞机信息在订单主表的航班班次中有
	// team信息同上
	private tank tank;
	private customer customer;//对应机票乘坐人
	private seat seat;
	public String getDetailsno() {
		return detailsno;
	}

	public void setDetailsno(String detailsno) {
		this.detailsno = detailsno;
	}

	public int getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}

	public String getTicketstatus() {
		return ticketstatus;
	}

	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}

	public ordermaster getOrder() {
		return order;
	}

	public void setOrder(ordermaster order) {
		this.order = order;
	}

	public tank getTank() {
		return tank;
	}

	public void setTank(tank tank) {
		this.tank = tank;
	}

	public customer getCustomer() {
		return customer;
	}

	public void setCustomer(customer customer) {
		this.customer = customer;
	}

	public seat getSeat() {
		return seat;
	}

	public void setSeat(seat seat) {
		this.seat = seat;
	}
}
