package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session3")
public class LoginSession3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginSession3() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String password= request.getParameter("password");
		
		HttpSession session= request.getSession(false);
		String category= (String) session.getAttribute("category");
		String email= (String) session.getAttribute("email");
		
		out.println("<h1>Welcome " + category + "!</h1>");
		out.println("<p>These are your login credentials:</p>");
		out.println("Email: " + email + "<br />");
		out.println("Password: " + password);
	}

}
