package tranferAmount;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Model;
import tranaction.Transaction;

@SuppressWarnings("serial")
public class TranferAmountController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try {
			HttpSession session = req.getSession();
			Model m = new Model();
			if(m.isAccountValid(req.getParameter("accNo"),req.getParameter("name")))
			{
				m.setAccNo((String)session.getAttribute("accNo"));
				if(m.isTranferAmount(Integer.parseInt(req.getParameter("amount"))))
				{
					System.out.println("Enter into second if-condition");
					Transaction t = new Transaction();
					t.setTranactionAccountNo(req.getParameter("accNo"));
					t.setTranactionAccountHolderName(req.getParameter("name"));
					t.setTranactionAmount(req.getParameter("amount"));
					if(m.tranferAmount(t))
					{
						System.out.println("Enter into third if-condition");
						session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-success\">" +
															"<strong>Transaction Success ! </strong> Tranfer Amount successfully... <a href=\"TranactionController\">View Statement</a>" + 
														"</div>");
						res.sendRedirect("/GromingBank/tranferAmount.jsp");
					}
					else
					{
						session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
															"<strong>Transaction Failed ! </strong> Transfer failed..." +
														"</div>");
						res.sendRedirect("/GromingBank/tranferAmount.jsp");
					}
				}
				else
				{
					session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
													"<strong>Transaction Failed ! </strong> Insufficent balance..." +
												"</div>");
					res.sendRedirect("/GromingBank/tranferAmount.jsp");
				}
			}
			else
			{
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
													"<strong>Failed ! </strong> Account number or/and Holder name does't match..." +
												"</div>");
				res.sendRedirect("/GromingBank/tranferAmount.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
