package cn.jxufe.db.dao.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cn.jxufe.db.connDB.ConnDB;
import cn.jxufe.db.domain.user;
import pers.gulo.fm.dao.UserDao;
import pers.gulo.fm.exception.FMException;
import sun.security.timestamp.TSRequest;

public class UserDaoImpl implements UserDao {
	ConnDB conn = new ConnDB();

	@Override
	public user login(String username, String password) {
		List<user> userList = new ArrayList<>();
		String sql = "select * from USERS where USERNAME='"+username+"' and PASSWORD='"+password+"'";
		PreparedStatement psmt = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			psmt = conn.getConn().prepareStatement(sql);
			//psmt.setString(1, username);
			//psmt.setString(2, password);
			rs = psmt.executeQuery();
//			cs = conn.getConn().prepareCall("{call select_user_out(?,?,?,?}");
//			cs.setString(1, username);
//			cs.setString(2, password);
//			cs.registerOutParameter(3, Types.INTEGER);
//			cs.registerOutParameter(4, Types.VARCHAR);
//			cs.execute();
//			user.setType(cs.getInt(3));
//			user.setUserno(cs.getString(4));
			while (rs.next()) {
				user user = new user();
				user.setUserno(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setRegistercardno(rs.getString(3));
				user.setRegisterphoneno(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setType(rs.getInt(6));
				userList.add(user);
				System.out.println("user:" + user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.commitConn();
			conn.closeConn();
		}
		return userList.get(0);
	}

	@Override
	public void insertUser(user user) throws FMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void reCharge(user user, float number) {
		// TODO Auto-generated method stub

	}

}
