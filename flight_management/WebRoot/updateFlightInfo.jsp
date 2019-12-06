
<%@page import="cn.jxufe.db.domain.flightclass"%>
<%@page import="cn.jxufe.db.service.impl.AdminServiceImpl"%>
<%@page import="cn.jxufe.db.service.AdminService"%>
<%@page import="cn.jxufe.db.domain.flight"%>
<%@page import="cn.jxufe.db.domain.user"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	user user =(user)session.getAttribute("user");
	if(user==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}else{
		if(user.getType()!=1){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}
	String flightNo=request.getParameter("flightNo");
	AdminService aService =new AdminServiceImpl();
	List<flightclass> flightList= aService.listAllFlight();
	for(flightclass flightclass:flightList){
		if(flightclass.getFlightclassno() == flightNo){
			request.setAttribute("flightclass", flightclass);
			break;
		}
	}
 %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<meta name="description" content="">
		<meta name="author" content="">
		<title>修改航班信息</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="jsjquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="container">
			<h2 class="sub-header">修改航班信息</h2>
			<form class="form-horizontal" role="form" method="post" action="servlet/UpdateFlightServlet">
			
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">航班编号</label>
					<div class="col-sm-10">
						<input class="form-control" id="disabledInput" type="text" placeholder="" name="no">
						<input type="hidden" name="flightno" value=" ">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">班机编号</label>
					<div class="col-sm-10">
						<input class="form-control" id="focusedInput" type="text" name="planeno" value=" ">
					</div>
				</div>
				
				<%-- <div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">出发地</label>
					<div class="col-sm-10">
						<input class="form-control" id="disabledInput" type="text" placeholder="${flightclass.flyplace}" disabled name="flyplace">
						<input type="hidden" name="flyplace" value="${flightclass.flyplace}">
					</div>
				</div> --%>
				
				<%-- <div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">目的地</label>
					<div class="col-sm-10">
						<input class="form-control" id="disabledInput" type="text" placeholder="${flightclass.arrival}" disabled name="arrival">
						<input type="hidden" name="arrival" value="${flightclass.arrival}">
					</div>
				</div> --%>
				
				<%-- <div class="form-group">
					<label class="col-sm-2 control-label">价格</label>
					<div class="col-sm-10">
						<input class="form-control" id="focusedInput" type="text" name="price" value="${flightclass.price}">
					</div>
				</div> --%>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">起飞时间</label>
					<div class="col-sm-10">
						<input class="form-control" id="focusedInput" type="text" name="takeoff" value=" ">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">起飞时间</label>
					<div class="col-sm-10">
						<input class="form-control" id="focusedInput" type="text" name="arrival" value=" ">
					</div>
				</div>
				
			<button type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</body>

</html>
