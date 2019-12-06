package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.service.AdminService;
import cn.jxufe.db.service.impl.AdminServiceImpl;


public class DeleteFlightServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightNo=new String(request.getParameter("flightNo").getBytes("ISO-8859-1"),"UTF-8");
		AdminService aService=new AdminServiceImpl();
		flightclass flightclass=new flightclass();
		flightclass.getFlight().setFlightno(flightNo);
		try {
			aService.deleteFlight(flightclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("flightManageMsg", e.getMessage());
			e.printStackTrace();
		}finally{
			response.sendRedirect(request.getContextPath()+"/flightManage.jsp");
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
