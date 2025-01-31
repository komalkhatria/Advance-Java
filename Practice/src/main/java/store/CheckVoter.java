package store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/vote")
public class CheckVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckVoter() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		
		if(Integer.parseInt(age)>=18) {
			out.println("<h3 style='color: green'>" + name + ", you are eligible to vote!</h3>");
		}
		else {
			out.println("<h3 style='color: red'>" + name + ", you are not eligible to vote!</h3>");
		}
	}

}
