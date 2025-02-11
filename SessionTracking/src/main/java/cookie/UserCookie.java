package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie1")
public class UserCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserCookie() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("name");
		Cookie nameCookie= new Cookie("name", name);
		response.addCookie(nameCookie);
		
		out.println("<form action= 'cookie2' method= 'post'>");
		out.println("<label for='gender'>Gender</label>");
		out.println("<input type='radio' name='gender' value='male' required/> <label for='male'>Male</label>");
		out.println("<input type='radio' name='gender' value='female'/> <label for='female'>Female</label>");
		out.println("<button type='submit'>Submit</button>");
		out.println("</form>");
	}

}
