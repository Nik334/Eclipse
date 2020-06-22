package forgetPassword;

import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Model;

@SuppressWarnings("serial")
public class ForgetPwdController extends HttpServlet 
{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			HttpSession session = req.getSession();
			Model m = new Model();
			m.setCustId(req.getParameter("custId"));
			if(m.isAccountValid(req.getParameter("custId")))
			{
				session.setAttribute("message", sendMail(m.getEmail(),m));
				res.sendRedirect("/GromingBank/message.jsp");
			}
			else
			{
				session.setAttribute("error", "<div id=\"myAlert\" class=\"alert alert-danger\">" +
												"<strong>Failed ! </strong> Enter valid Customer ID" +
											"</div>");
				res.sendRedirect("/GromingBank/forgetPassword.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String sendMail(String recipient,Model m)
	{
		String host = "smtp.gmail.com";
		String port = "587";
		String email = "nikkumar334@gmail.com";
		String name = "Nikhil";
		String pass = "Upcomingtime";
		String subject = "Your Password has been reset";
		 
        String newPassword = randomPassword(10);
        String content = "Hi, this is your new password: " + newPassword;
        content += "\nNote: for security reason"
                + " you must change your password after logging in.";
        
        String message = "";
 
        try {
            EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, content);
            m.setRandomPwd(newPassword);
            message = "Your password has been reset. Please check your e-mail.";
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        }
        System.out.println("Message => "+message);
        return message;
	}
	static String randomPassword(int len) 
    {
        String Capital_chars = "ABCDEFGHJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijkmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
        String symbols = "!@#$+/"; 
  
        String values = Capital_chars + Small_chars + numbers + symbols; 
  
        Random rndm_method = new Random(); 
  
        String password = new String(); 
  
        for (int i = 0; i < len; i++) 
        { 
            password += values.charAt(rndm_method.nextInt(values.length())); 
  
        } 
        return password; 
    } 
}
