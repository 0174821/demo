package cn.jxufe.db.service.impl;

import java.util.List;

import cn.jxufe.db.dao.AdminDao;
import cn.jxufe.db.dao.impl.AdminDaoImpl;
import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public List<user> listAllUser() {
		AdminDao aDao = new AdminDaoImpl();
		List<user> queryUsers = aDao.queryUsers();
		return queryUsers;
	}

	/*
	 * public void deleteUser(User user) throws FMException{ AdminDao aDao=new
	 * AdminDaoImpl(); aDao.deleteUser(user); }
	 * 
	 * @Override public void updateUser(User user) throws FMException { AdminDao
	 * aDao=new AdminDaoImpl(); aDao.updateUser(user); }
	 */

	@Override
	public List<flightclass> listAllFlight() {
		AdminDao aDao = new AdminDaoImpl();
		return aDao.queryAllFlight();

	}
	/*
	 * @Override public void updateFlight(Flight flight) throws FMException {
	 * AdminDao aDao=new AdminDaoImpl(); aDao.updateFlight(flight);
	 * 
	 * }
	 * 
	 * @Override public void addFlight(Flight flight) throws FMException { AdminDao
	 * aDao=new AdminDaoImpl(); aDao.insertFlight(flight); }
	 * 
	 * @Override public void deleteFlight(Flight flight) throws FMException {
	 * AdminDao aDao=new AdminDaoImpl(); aDao.deleteFlight(flight); }
	 */

	@Override
	public List<plane> listAllAirPlane() {
		AdminDao aDao = new AdminDaoImpl();
		List<plane> queryAllAirPlane = aDao.queryAllAirPlane();
		return queryAllAirPlane;
	}
	/*
	 * @Override public void addAirPlane(AirPlane airPlane) throws FMException {
	 * AdminDao aDao=new AdminDaoImpl(); aDao.insertAirPlane(airPlane); }
	 * 
	 * @Override public void deleteAirPlane(AirPlane airPlane) throws FMException {
	 * AdminDao aDao=new AdminDaoImpl(); aDao.deleteAirPlane(airPlane); }
	 */

	@Override
	public List<orderdetail> listAllOrder() {
		AdminDao aDao = new AdminDaoImpl();
		return aDao.queryAllOrder();
	}
	/*
	 * @Override public Statistic makeStatistic() { AdminDao aDao=new
	 * AdminDaoImpl(); return aDao.makeStatistic(); }
	 */
	public void updateUser(user user) {
		
	}
	
	public void updateFlightclass(flightclass flightclass) {
		
	}
	
	public void deleteFlight(flightclass flightclass) {
		
	}
	
	public void deleteAirPlane(plane plane) {
		
	}
	
	public void addAirPlane(plane airPlane) {
		
	}
	
	public void addFlight(flightclass flightclass) {
		
	}
}
