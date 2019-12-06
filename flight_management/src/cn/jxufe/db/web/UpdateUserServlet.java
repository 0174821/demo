package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.AdminService;
import cn.jxufe.db.service.impl.AdminServiceImpl;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("userManageMsg");
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String id=request.getParameter("id");
	    String userno =new String(request.getParameter("no").getBytes("ISO-8859-1"),"UTF-8");
		
		user user =new user();
		user.setUserno(userno);
		user.setUsername(username);
		user.setRegistercardno(id);
		
		AdminService aService=new AdminServiceImpl();
		try {
			aService.updateUser(user);
		} catch (Exception e) {
			request.getSession().setAttribute("userManageMsg", e.getMessage());
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/userManage.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
