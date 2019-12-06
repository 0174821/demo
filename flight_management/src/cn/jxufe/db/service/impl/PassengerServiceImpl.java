package cn.jxufe.db.service.impl;
import java.sql.Date;
import java.util.List;

import cn.jxufe.db.dao.PassengerDao;
import cn.jxufe.db.dao.impl.PassengerDaoimpl;
import cn.jxufe.db.domain.customer;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.domain.seat;
import cn.jxufe.db.domain.tank;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.PassengerService;



public class PassengerServiceImpl implements PassengerService{
	PassengerDao aDao=new PassengerDaoimpl();
	
	@Override
	public void cancle(ordermaster order) {
		
	}
	@Override
	public void payFlight(ordermaster order) {
		
	}
	@Override
	public void bookFlight(user user, flight flight) {
		
	}
	@Override
	public List<flightclass> findFlightByStartAndDist(String start,String dist,Date godate)
	{
		return aDao.findFlightByStartAndDist(start,dist,godate);
	}
	@Override
	public List<tank> findtank(flightclass flightclass)
	{
		return aDao.findtank(flightclass);
	}
	@Override
	public ordermaster creatOrdermaster(flightclass flightclass,user user)
	{
		return aDao.creatOrdermaster(flightclass,user);
	}
	@Override
	public boolean creatOrderdetail(flightclass flightclass, tank tank, ordermaster ordermaster,customer customer)
	{
		return aDao.creatOrderdetail(flightclass,tank,ordermaster,customer);
	}
	@Override
	public List<orderdetail> qrydetailBymaster(ordermaster ordermaster)
	{
		return aDao.qrydetailBymaster(ordermaster);
	}
	@Override
	public boolean delOrderdetail(orderdetail orderdetail) 
	{
		return aDao.delOrderdetail(orderdetail);
		
	}
	@Override
	public boolean delwholeOrder(ordermaster ordermaster) {
		return aDao.delwholeOrder(ordermaster);
		
	}
	@Override
	public List<orderdetail> qrydetailByCustomer(customer customer) 
	{
		return aDao.qrydetailByCustomer(customer);
	}
	@Override
	public List<seat> findOkseat(orderdetail orderdetail)
	{
		return aDao.findOkseat(orderdetail);
	}
	@Override
	public boolean selectSeat(seat seat, orderdetail orderdetail)
	{
		return aDao.selectSeat(seat, orderdetail);
		
	}
	@Override
	public boolean delSeat(orderdetail orderdetail)
	{
		return aDao.delSeat(orderdetail);
		
	}
}