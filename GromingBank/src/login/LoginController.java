package login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class LoginController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
	{
		try {
			Model m = new Model();
			m.setCustId(req.getParameter("custId"));
			m.setPws(req.getParameter("pws"));
			HttpSession session = req.getSession(true);
			if(m.login())
			{
				session.setAttribute("accNo", m.getAccNo());
				res.sendRedirect("/GromingBank/home.jsp");
			}
			else
			{
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
												"<strong>Failed ! </strong> Login Failed..." +
											"</div>");
				res.sendRedirect("/GromingBank/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
