package balance;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Model;

@SuppressWarnings("serial")
public class BalanceController extends HttpServlet 
{	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
	{
		try {
			HttpSession session = req.getSession();
			Model m = new Model();
			m.setAccNo((String)session.getAttribute("accNo"));
			System.out.println(session.getAttribute("accNo"));
			if(m.accBalance())
			{
				session.setAttribute("balance", m.getBalance());
				res.sendRedirect("/GromingBank/balance.jsp");
			}
			else
			{
				session.setAttribute("error", "Unable to fetch balance... Try again later");
				res.sendRedirect("/GromingBank/balance.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
