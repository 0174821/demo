package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.db.domain.user;
import pers.gulo.fm.service.UserService;
import pers.gulo.fm.service.impl.UserServiceImpl;

public class RechargeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService uService=new UserServiceImpl();
		user user=new user();
		user.setUserno(new String(request.getParameter("userno").getBytes("ISO-8859-1"),"UTF-8"));
		float number=Float.parseFloat(request.getParameter("number"));
		uService.recharge(user,number);
		
		user sessionUser=(user) request.getSession().getAttribute("user");
		//sessionUser.setBalance(sessionUser.getBalance()+number);
		//找钱
		response.sendRedirect(request.getContextPath()+"/myWallet.jsp");
		request.getSession().setAttribute("myWalletMsg", "充值成功！");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
