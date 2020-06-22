<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="tranaction.Transaction" %>
    <%@ page import="java.util.ArrayList" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statement</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid">
    <div class="row">
    	<h1>Statements</h1><hr>
    	<%if(session.getAttribute("error") != null){
			out.print(session.getAttribute("error")); 
			session.removeAttribute("error");
		}else{%>
        <div class="table-responsive">
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Account Number</th>
                        <th>Account Holder Name</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                <%if(session.getAttribute("statement") != null){%>
	                <%for(Transaction data : ((ArrayList<Transaction>)(session.getAttribute("statement")))){ %>
	                    <tr>
	                        <td><% out.println(data.getTranactionAccountNo()); %></td>
	                        <td><% out.println(data.getTranactionAccountHolderName()); %></td>
	                        <td><% out.println(data.getTranactionAmount()); %></td>
	                    </tr>
	                <%} %>
	             <% }%>
	             <%} %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>