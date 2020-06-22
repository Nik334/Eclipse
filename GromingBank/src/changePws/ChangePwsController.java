package changePws;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Model;

@SuppressWarnings("serial")
public class ChangePwsController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			HttpSession session = req.getSession();
			Model m = new Model();
			m.setAccNo((String)session.getAttribute("accNo"));
			if(m.checkOldPws() && m.getPws().equals((String)req.getParameter("oldPws")))
			{
				m.changePws((String)req.getParameter("newPws"));
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-success\">" +
													"<strong>Success ! </strong> Password change successfully..." +
												"</div>");
				res.sendRedirect("/GromingBank/changePassword.jsp");
			}
			else
			{
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
													"<strong>Failed ! </strong> Old password does't match..." +
												"</div>");
				res.sendRedirect("/GromingBank/changePassword.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
