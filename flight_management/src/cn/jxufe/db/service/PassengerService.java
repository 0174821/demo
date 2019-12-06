package cn.jxufe.db.service;

import java.sql.Date;
import java.util.List;

import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.domain.seat;
import cn.jxufe.db.domain.tank;
import cn.jxufe.db.domain.user;

public interface PassengerService {
	public List<flightclass> findFlightByStartAndDist(String start,String dist,Date godate);

	public List<tank> findtank(flightclass flightclass);
	
	public ordermaster creatOrdermaster(flightclass flightclass,user user);
	
	public boolean creatOrderdetail(flightclass flightclass, tank tank, ordermaster ordermaster,customer customer);
	
	public List<orderdetail> qrydetailBymaster(ordermaster ordermaster);
	
	public boolean delOrderdetail(orderdetail orderdetail);
	
	public boolean delwholeOrder(ordermaster ordermaster);
	
	public List<orderdetail> qrydetailByCustomer(customer customer) ;
	
	public List<seat> findOkseat(orderdetail orderdetail);
	
	public boolean selectSeat(seat seat, orderdetail orderdetail);
	
	public boolean delSeat(orderdetail orderdetail);

	public void cancle(ordermaster order);//未实现

	public void payFlight(ordermaster order);

	public void bookFlight(user user, flight flight);
	
}
