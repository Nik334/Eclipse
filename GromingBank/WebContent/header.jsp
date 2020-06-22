<!-- 	
	<div class="list-group list-group-flush">
		<a href="balance.jsp" class="list-group-item list-group-item-action bg-light">Balance</a>
		<a href="changePassword.jsp" class="list-group-item list-group-item-action bg-light">Change password</a>
		<a href="tranferAmount.jsp" class="list-group-item list-group-item-action bg-light">Transfer Amount</a>
		<a href="TranactionController" class="list-group-item list-group-item-action bg-light">Statements</a>
		<a href="logout.jsp" class="list-group-item list-group-item-action bg-light">Statements</a>
	</div>
-->
<%
if(session.getAttribute("accNo") == null)
{
	session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
			"<strong>Failed ! </strong> You must login first..." +
		"</div>");
%>
	<script type="text/javascript">
		window.location.href = "login.jsp";
	</script>
<%
}
%>
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="assests/images/Second.png" class="img-responsive" style="padding-left: 20px" width="145px" alt="LOGO">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li>
                <a href="logout.jsp" data-placement="bottom" data-toggle="tooltip" data-original-title="Logout"><i class="fa fa-fw fa-power-off"></i> Logout </a>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
            	<li>
                    <a href="home.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
                </li>
                <li>
                    <a href="BalanceController"><i class="fa fa-fw fa-money"></i> Balance</a>
                </li>
                <li>
                    <a href="changePassword.jsp"><i class="fa fa-fw fa-key"></i> Change Password</a>
                </li>
                <li>
                    <a href="tranferAmount.jsp"><i class="fa fa-fw fa fa-exchange"></i> Transfer Amount</a>
                </li>
                <li>
                    <a href="TranactionController"><i class="fa fa-fw fa fa-list-alt"></i> Statement</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>