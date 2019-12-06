package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.user;
import cn.jxufe.db.service.PassengerService;
import cn.jxufe.db.service.impl.PassengerServiceImpl;

public class QueryFlightServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//User user =(User) request.getSession().getAttribute("user");
		user user = (user) request.getSession().getAttribute("user");
		//Dao unImpl
		PassengerService pService = new PassengerServiceImpl();
//		String username= request.getParameter("start");
//		String password =request.getParameter("starttime");
//		String password =request.getParameter("arrival");
		String flightNo=new String(request.getParameter("flightno").getBytes("ISO-8859-1"),"UTF-8");
		flight flight=new flight();
		flight.setFlightno(flightNo);
		try {
			pService.bookFlight(user,flight);//unImpl
			request.getSession().setAttribute("bookFlightMsg", "预订成功！");
		} catch (Exception e) {
			request.getSession().setAttribute("bookFlightMsg", "预订失败！余票不足！");
			e.printStackTrace();
		}finally{
			response.sendRedirect(request.getContextPath()+"/bookFlight.jsp");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}