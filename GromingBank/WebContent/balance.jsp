<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Balance</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid">
	<%if(session.getAttribute("balance") != null){
		%>
		Your Balance is : <% out.println(session.getAttribute("balance"));%>
	<%}else
		{
			out.println(session.getAttribute("error"));
		}
		%>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>