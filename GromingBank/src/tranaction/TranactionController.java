package tranaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Model;

@SuppressWarnings("serial")
public class TranactionController extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			Model m = new Model();
			HttpSession session = request.getSession();
			m.setAccNo((String)session.getAttribute("accNo"));
			if(m.getStatement().isEmpty())
			{
				session.setAttribute("error", "No Trnsaction history");
				response.sendRedirect("/GromingBank/transaction.jsp");
			}
			else
			{
				session.setAttribute("statement", m.getStatement());
				response.sendRedirect("/GromingBank/transaction.jsp");
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
