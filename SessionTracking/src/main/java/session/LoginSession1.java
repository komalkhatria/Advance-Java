package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session1")
public class LoginSession1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginSession1() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String category= request.getParameter("category");
		HttpSession session= request.getSession();
		session.setAttribute("category", category);
		
		out.println("<form action='session2' method='post'>");
		out.println("<label for='email'>Email: </label>");
		out.println("<input type='email' name='email' required/> <br />");
		out.println("<button type='submit'>Next</button>");
	    out.println("</form>");
		
	}

}
