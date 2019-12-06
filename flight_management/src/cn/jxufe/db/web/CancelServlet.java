package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.ordermaster;
import cn.jxufe.db.service.PassengerService;
import cn.jxufe.db.service.impl.PassengerServiceImpl;

public class CancelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String orderNo=new String(request.getParameter("orderNo").getBytes("ISO-8859-1"),"UTF-8");
			
			PassengerService pService = new PassengerServiceImpl();
			ordermaster order = new ordermaster();
			
			order.setOrderno(orderNo);
			try {
				pService.cancle(order);
				//user sessionUser = (user) request.getSession().getAttribute("user");
				//sessionUser.setBalance(sessionUser.getBalance()+order.getFlight().getPrice());
				request.getSession().setAttribute("myOrderMsg", "取消订单成功！");
			} catch (Exception e) {
				request.getSession().setAttribute("myOrderMsg", "取消订单失败！");
				e.printStackTrace();
			}finally{
				response.sendRedirect(request.getContextPath()+"/myOrder.jsp");
			}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
