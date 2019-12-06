package pers.gulo.fm.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.jxufe.db.dao.resultSetHandler.UserResultSetHandler;
import cn.jxufe.db.domain.user;
import pers.gulo.fm.dao.UserDao;
import pers.gulo.fm.exception.FMException;
import pers.gulo.fm.utils.DaoUtils;

public class UserDaoImpl implements UserDao {
	
	private static final String CHECK_LOGIN_SQL="call SELECT_USER_OUT(?,?,?,?)";
	
	private static final String INSERT_USER_SQL="insert into USERS values (0,?,?,?,?,?)";
	
	private static final String RECHARGE_SQL="update T_USER set U_BALANCE =U_BALANCE + ? where U_NO=?";
	
	@Override
	public user login(String username, String password) {
		user user=null;
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		try {
			List<user> list=runner.query(CHECK_LOGIN_SQL,new UserResultSetHandler(), username, password, java.sql.Types.INTEGER, java.sql.Types.VARCHAR);
			for (user u: list) {
				System.out.println(u);
			}
			System.out.print("1312312");
			if(list!=null&&list.size()!=0) user=list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public void insertUser(user user) throws FMException {
		QueryRunner runner =new QueryRunner(DaoUtils.getSource());
		try {
			runner.update(INSERT_USER_SQL,user.getUsername(),user.getRegistercardno(),user.getRegisterphoneno(),user.getPassword(),user.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FMException("发生错误或用户名被占用！请重新注册！");
		}
		
	}
	
	@Override
	public void reCharge(user user, float number) {
		QueryRunner runner =new QueryRunner(DaoUtils.getSource());
		try {
			runner.update(RECHARGE_SQL,number,user.getUserno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
