<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change password</title>
</head>
<body>
<form action="ChangePwsController">
<jsp:include page="header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid">
	<div class="h1">Change password</div><hr>
		<div class="row">
			<div class="col-md-6">
				<%if(session.getAttribute("error") != null){
					out.print(session.getAttribute("error"));
					session.removeAttribute("error");
				}%>
				<div class="form-group">
					<label for="oldPws">Old password</label>
					<input class="form-control" type="password" placeholder="Enter old password" id="oldPws" name="oldPws" required="true" autofocus="autofocus" data-toggle="password">
				</div>
				<div class="form-group">
					<label for="newPws">New Password</label>
					<input class="form-control" type="password" placeholder="Enter new password" id="newPws" name="newPws" required="true" data-toggle="password">
				</div>
				<div class="form-group">
					<label for="confirmNewPws">Confirm new Password</label>
					<input class="form-control" type="password" placeholder="Enter confirm new password" id="confirmNewPws" name="confirmNewPws" required="true" data-toggle="password">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-warning" value="Change Password">
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</form>
</body>
</html>