package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jxufe.db.domain.*;

import pers.gulo.fm.exception.FMException;
import pers.gulo.fm.service.UserService;
import pers.gulo.fm.service.impl.UserServiceImpl;

public class AddUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService=new UserServiceImpl();
		user user =new user();
		user.setUsername(new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8"));
		user.setPassword(request.getParameter("password"));
		//user.setNickname(new String(request.getParameter("nickname").getBytes("ISO-8859-1"),"UTF-8"));
		user.setUserno(request.getParameter("userno"));
		try {
			userService.addUser(user);  
			request.getSession().setAttribute("loginMsg", "注册成功！");
		} catch (FMException e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("loginMsg", e.getMessage());
			e.printStackTrace();
		}finally{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
