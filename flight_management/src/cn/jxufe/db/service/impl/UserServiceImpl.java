package cn.jxufe.db.service.impl;

import cn.jxufe.db.dao.impl.UserDaoImpl;
import cn.jxufe.db.domain.user;
import pers.gulo.fm.dao.UserDao;
import pers.gulo.fm.exception.FMException;
import pers.gulo.fm.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public user login(String username, String password) {
		UserDao uDao=new UserDaoImpl();
		return uDao.login(username, password);
	}
	
	@Override
	public void addUser(user user) throws FMException {
		UserDao uDao=new UserDaoImpl();
		uDao.insertUser(user);
	}
	
	@Override
	public void recharge(user user, float number) {
		UserDao uDao=new UserDaoImpl();
		uDao.reCharge(user,number);
		
	}

}
