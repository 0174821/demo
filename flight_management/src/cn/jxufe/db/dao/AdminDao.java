package cn.jxufe.db.dao;

import java.util.List;

import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.orderdetail;
import cn.jxufe.db.domain.plane;
import cn.jxufe.db.domain.user;

public interface AdminDao {
	
	/**
	 * 查询所有班机
	 * @return
	 */
	public List<plane> queryAllAirPlane();
	/**
	 * 添加新的班机
	 * @param airPlane
	 */
	//public void insertAirPlane(AirPlane airPlane) throws FMException;
	
	/**
	 * 删除一个班机
	 * @param airPlane
	 */
	//public void deleteAirPlane(AirPlane airPlane) throws FMException;
	
	/**
	 * 添加新的航班
	 * @param flight
	 */
	//public void insertFlight(Flight flight) throws FMException;

	/**
	 * 修改航班信息
	 * @param flight
	 */
	//public void updateFlight(Flight flight) throws FMException;
	
	/**
	 * 查询所有旅客信息
	 * @return
	 */
	public List<user> queryUsers();

	/**
	 * 删除一条航班
	 * @param flight
	 */
	//public void deleteFlight(Flight flight) throws FMException;

	/**
	 * 查询所有航班信息
	 * @return
	 */
	public List<flightclass> queryAllFlight();
	
	//public void deleteUser(User user) throws FMException;
	
	//public void updateUser(User user) throws FMException;
	
	public List<orderdetail> queryAllOrder();
	
	//public Statistic makeStatistic();
	
	
}
