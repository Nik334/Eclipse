<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assests/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Forget Password</title>
</head>
<body>
<form action="ForgetPwdController">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div class="h1">Forget password</div><hr>
				<%if(session.getAttribute("error") != null){
					out.print(session.getAttribute("error")); 
					session.removeAttribute("error");
				}%>
				<div class="form-group">
					<label for="username">Customer ID</label>
					<input type="text" class="form-control" name="custId" id="custId" placeholder="Enter Customer ID" required="true" autofocus="autofocus">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-info" value="Send Mail">
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>