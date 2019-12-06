package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.plane;
import cn.jxufe.db.service.AdminService;
import cn.jxufe.db.service.impl.AdminServiceImpl;

public class DeleteAirPlaneServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no=new String(request.getParameter("airPlaneNo").getBytes("ISO-8859-1"),"UTF-8");
		//AirPlane airPlane=new AirPlane();
		plane plane = new plane();
		plane.setPlaneno(no);
		
		AdminService aService=new AdminServiceImpl();
		try {
			aService.deleteAirPlane(plane);//unImpl
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("airPlaneManageMsg", e.getMessage());
			e.printStackTrace();
		}finally{
			response.sendRedirect(request.getContextPath()+"/airPlaneManage.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
