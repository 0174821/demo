
<%@page import="cn.jxufe.db.domain.flightclass"%>
<%@page import="cn.jxufe.db.service.impl.AdminServiceImpl"%>
<%@page import="cn.jxufe.db.service.AdminService"%>
<%@page import="cn.jxufe.db.dao.impl.PassengerDaoimpl"%>
<%@page import="cn.jxufe.db.dao.PassengerDao"%>
<%@page import="cn.jxufe.db.domain.flight"%>
<%@page import="cn.jxufe.db.domain.user"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	user user =(user)session.getAttribute("user");
	if(user==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	String start=null;
	String dist=null;
	try{
		start=new String(request.getParameter("flyplace").getBytes("ISO-8859-1"),"UTF-8");
		}catch(Exception e){
	}
	
	try{
		dist=new String(request.getParameter("arriveplace").getBytes("ISO-8859-1"),"UTF-8");
		}catch(Exception e){
	}


	/* PassengerDao pDao=new PassengerDaoimpl();
	List<flightclass> queryflightList=pDao.findFlightByStartAndDist(start, dist);
	request.setAttribute("queryflightList", queryflightList);
	request.setAttribute("queryflightListLength", queryflightList.size()); */
	AdminService aService=new AdminServiceImpl();
	List<flightclass> flightList = aService.listAllFlight();
	request.setAttribute("flightList", flightList);
	request.setAttribute("flightListLength", flightList.size());
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
	<title>机票预订系统</title>

    <!-- Bootstrap core CSS -->
    <link href="./Dashboard Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./Dashboard Template for Bootstrap_files/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://v3.bootcss.com/examples/dashboard/#">机票预订系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="servlet/LogoutServlet">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="user.jsp">主页 </a></li>
            <li><a href="bookFlight.jsp">机票预订</a></li>
            <li class="active"><a href="#">航班查询<span class="sr-only">(current)</span></a></li>
            <li><a href="myOrder.jsp">我的订单</a></li>
            <li><a href="myWallet.jsp">我的钱包</a></li>
          </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <c:if test="${sessionScope.queryFlightMsg!=null}">
			<div class="alert alert-info" role="alert">
				${queryFlightMsg}
				${sessionScope.queryFlightMsg=null}
			</div>
			</c:if>
			<form class="form-inline" method="post" action="queryFlight.jsp">
			  <div class="form-group">
			    <label for="exampleInputName2">出发地</label>
			    <input type="text" class="form-control" id="exampleInputName1" placeholder="出发地" name="start">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">目的地</label>
			    <input type="text" class="form-control" id="exampleInputName2" placeholder="目的地" name="dist">
			  </div>
			  <button type="submit" class="btn btn-default">查询</button>
			</form>
<h2 class="sub-header">查询到如下航班信息</h2>
          <%-- <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>航班班次编号</th>
                 <th>航班编号</th>
                 <th>飞机型号</th>
                 <th>起飞时间</th>
                 <th>到达时间</th>
				 <th>飞机编号</th>
				 <th>机组号</th>
				 <th>日期</th>
                </tr>
              </thead>
              <tbody>
			<c:forEach var="f" items="${queryflightList}">
				 <tr>
                  <td><c:out value="${f.flightclassno}"/></td>
                  <td><c:out value="${f.flightno}"/></td>
                  <td><c:out value="${f.planetypeno}"/></td>
                  <td><c:out value="${f.takeoff}"/></td>
                  <td><c:out value="${f.arrival}"/></td>
                  <td><c:out value="${f.planeno}"/></td>
                  <td><c:out value="${f.teamno}"/></td>
                  <td><c:out value="${f.dates}"/></td>
                  <td>
                  	<button type="button" class="btn btn-xs btn-success" onclick="javascript:window.location.href='servlet/BookServlet?flightNo=${f.no}';">预订</button>
                  </td>
                </tr>
			</c:forEach>
                
              </tbody>
            </table>
            
          </div> --%>
			<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                 <th>航班班次编号</th>
                 <th>航班编号</th>
                 <th>飞机型号</th>
                 <th>起飞时间</th>
                 <th>到达时间</th>
				 <th>飞机编号</th>
				 <th>机组号</th>
                </tr>
              </thead>
              <tbody>
			<c:forEach var="f" items="${flightList}">
				 <tr>
                  <td><c:out value="${f.flightclassno}"/></td>
                  <td><c:out value="${f.flight.getFlightno()}"/></td>
                  <td><c:out value="${f.plane.getPlanetype().getTypeno()}"/></td>
                  <td><c:out value="${f.takeoff}"/></td>
                  <td><c:out value="${f.arrival}"/></td>
                  <td><c:out value="${f.plane.getPlaneno()}"/></td>
                  <td><c:out value="${f.team.getTeamno()}"/></td>
                  <td>
                  	<button type="button" class="btn btn-xs btn-warning" onclick="javascript:window.location.href='updateFlightInfo.jsp?flightNo=${f.flightclassno}';">修改</button>
                  	<button type="button" class="btn btn-xs btn-danger" onclick="javascript:window.location.href='servlet/DeleteFlightServlet?flightNo=${f.flightclassno}';">删除</button>
                  </td>
                </tr>
			</c:forEach>
                
              </tbody> 
            </table>
            <button type="button" class="btn btn-lg btn-success" onclick="javascript:window.location.href='addFlight.jsp';">新增航班</button>
          </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./Dashboard Template for Bootstrap_files/jquery.min.js"></script>
    <script src="./Dashboard Template for Bootstrap_files/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./Dashboard Template for Bootstrap_files/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>
  

</body></html>
