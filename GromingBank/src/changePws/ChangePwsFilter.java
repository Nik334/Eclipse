package changePws;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePwsFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	{
		try {
			if(request.getParameter("newPws").equals(request.getParameter("confirmNewPws")))
			{
				chain.doFilter(request, response);
			}
			else
			{
				HttpSession session = ((HttpServletRequest)(request)).getSession();
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
													"<strong>Failed ! </strong> Password does't match..." +
												"</div>");
				((HttpServletResponse)(response)).sendRedirect("/GromingBank/changePwsFail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
