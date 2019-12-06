package pers.gulo.fm.dao;


import cn.jxufe.db.domain.user;
import pers.gulo.fm.exception.FMException;

public interface UserDao {
	/**
	 * 根据用户名密码检查登录，若查询到用户则返回该用户信息，若无结果返回null。
	 * @param username
	 * @param password
	 * @return
	 */
	public user login(String username,String password);
	
	public void insertUser(user user) throws FMException;

	public void reCharge(user user, float number); 

}
