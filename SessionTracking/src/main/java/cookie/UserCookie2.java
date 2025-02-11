package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie2")
public class UserCookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserCookie2() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String gender= request.getParameter("gender");
		String sign= "dear";
		if(gender.equals("male")) {
			sign= "Mr. ";
		}
		else if(gender.equals("female")) {
			sign= "Ms. ";
		}
		
		String name= "guest";
		Cookie[] cookies= request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("name")) {
					name= cookie.getValue();
					break;
				}
			}
		}
		
		
		out.println("<h1>Welcome " + sign + name + "</h1>");
	}

}
