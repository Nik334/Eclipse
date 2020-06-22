<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Amount</title>
</head>
<body>
<form action="TranferAmountController">
<jsp:include page="header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<div class="h1">Transfer Amount</div><hr>
				<%if(session.getAttribute("error") != null){
					out.print(session.getAttribute("error")); 
					session.removeAttribute("error");
				}%>
				<div class="form-group">
					<label for="accNo">Account Number</label>
					<input class="form-control" type="text" placeholder="Enter account number" id="accNo" name="accNo" required="true" autofocus="autofocus">
				</div>
				<div class="form-group">
					<label for="accNo">Account holder name</label>
					<input class="form-control" type="text" placeholder="Enter holder name" id="name" name="name" required="true" autofocus="autofocus">
				</div>
				<div class="form-group">
					<label for="amount">Amount</label>
					<input class="form-control" type="text" placeholder="Enter amount" id="amount" name="amount" required="true">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-warning" value="Tranfer Amount">
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</form>
</body>
</html>