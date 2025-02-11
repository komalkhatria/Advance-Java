package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session2")
public class LoginSession2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginSession2() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String email= request.getParameter("email");
		HttpSession session= request.getSession();
		session.setAttribute("email", email);
		
		out.println("<form action='session3' method='post'>");
		out.println("<label for='password'>Password: </label>");
		out.println("<input type='password' name='password' required/> <br />");
		out.println("<button type='submit'>Login</button>");
	    out.println("</form>");
	}

}
