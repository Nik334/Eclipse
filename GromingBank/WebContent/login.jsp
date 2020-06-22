<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assests/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="assests/js/jquery-2.2.0.min.js" type="text/javascript"></script>
<script src="assests/js/bootstrap-show-password.min.js" type="text/javascript"></script>
<title>Login page</title>
<style type="text/css">
	hr
	{
        height: 1px; 
        background: black;
	}
</style>
</head>
<body>
<form action="LoginController">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div class="h1">Login Grooming Bank</div><hr>
				<%if(session.getAttribute("error") != null){
					out.print(session.getAttribute("error")); 
					session.removeAttribute("error");
				}%>
				<div class="form-group">
					<label for="custId">Customer ID</label>
					<input class="form-control" type="text" placeholder="Enter Customer ID" id="custId" name="custId" required="true" autofocus="autofocus">
				</div>
				<div class="form-group">
					<label for="pws">Password </label>
					<div class="pull-right">
						<a href="forgetPassword.jsp">forget password ?</a>
					</div>
					<input class="form-control" type="password" placeholder="Enter password" id="pws" name="pws" required="true" data-toggle="password" data-toggle="password">
				</div>
				<div class="form-group pull-right">
                    Don't have account ? <a href="register.jsp">Register</a>
                </div>
				<div class="form-group">
					<input type="submit" class="btn btn-info" value="Login">
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>