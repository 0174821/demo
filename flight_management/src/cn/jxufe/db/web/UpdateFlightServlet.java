package cn.jxufe.db.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.flight;
import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.domain.plane;
import pers.gulo.fm.domain.AirPlane;
import pers.gulo.fm.domain.Flight;
import pers.gulo.fm.exception.FMException;
import pers.gulo.fm.service.AdminService;
import pers.gulo.fm.service.impl.AdminServiceImpl;

public class UpdateFlightServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("flightManageMsg");
		flightclass flightclass = new flightclass();
		flightclass.getFlight().setFlightno(new String(request.getParameter("flightno").getBytes("ISO-8859-1"),"UTF-8"));
		flightclass.getPlane().setPlaneno(new String(request.getParameter("planeno").getBytes("ISO-8859-1"),"UTF-8"));
//		flight.setPlane(airPlane);
//		flight.setFlyplace(new String(request.getParameter("flyplace").getBytes("ISO-8859-1"),"UTF-8"));
//		flight.setDistance(new String(request.getParameter("distance").getBytes("ISO-8859-1"),"UTF-8"));
		//flight.set(Float.parseFloat(request.getParameter("price"))); 价格
		//flight.setTime(Timestamp.valueOf(request.getParameter("time")));
		
		AdminService aService=new AdminServiceImpl();
		try {
			aService.updateFlightclass(flightclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("flightManageMsg", e.getMessage());
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/flightManage.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
