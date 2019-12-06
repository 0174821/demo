package cn.jxufe.db.service;

import java.util.List;

import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;

public interface AdminService{
	
	public List<user> listAllUser();
	
	/*public void deleteUser(User user) throws FMException;
	
	public void updateUser(User user) throws FMException;*/
	
	public List<flightclass> listAllFlight();
	
	/*public void updateFlight(Flight flight) throws FMException;
	
	public void addFlight(Flight flight)  throws FMException;
	
	public void deleteFlight(Flight flight) throws FMException;*/
	
	public List<plane> listAllAirPlane();

	/*public void addAirPlane(AirPlane airPlane) throws FMException ;

	public void deleteAirPlane(AirPlane airPlane) throws FMException;*/
	
	public List<orderdetail> listAllOrder();

	public void updateUser(user user);

	public void deleteFlight(flightclass flightclass);

	public void deleteAirPlane(plane plane);
	
	public void addAirPlane(plane airPlane);

	public void addFlight(flightclass flightclass);
	
	//public Statistic makeStatistic();

}
