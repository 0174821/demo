package cn.jxufe.db.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jxufe.db.domain.flightclass;
import cn.jxufe.db.service.AdminService;
import cn.jxufe.db.service.impl.AdminServiceImpl;

public class AddFlightServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("flightManageMsg");
		AdminService aService=new AdminServiceImpl();
		flightclass flightclass = new flightclass();
		//Flight flight=new Flight();
//		flight flight =new flight();
//		plane airPlane =new plane();
		//AirPlane airPlane=new AirPlane();
		flightclass.getPlane().setPlaneno(new String(request.getParameter("aNo").getBytes("ISO-8859-1"),"UTF-8"));
//		flight.setPlane(airPlane);
//		flightclass.getPlane().setFlyplace(new String(request.getParameter("start").getBytes("ISO-8859-1"),"UTF-8"));
//		flight.setArriveplace(new String(request.getParameter("dist").getBytes("ISO-8859-1"),"UTF-8"));
		//flight.set(Float.parseFloat(request.getParameter("price")));
		//flight.set(Timestamp.valueOf(request.getParameter("time")));
		
		try {
			aService.addFlight(flightclass);
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
