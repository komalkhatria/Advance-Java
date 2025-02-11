package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class SurveyAge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SurveyAge() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String name= request.getParameter("name");
		
		out.println("<form action='servlet2' method='post'>");
		out.println("<label for= 'age'>Age</label>");
		out.println("<input type= 'text' name='age' required/> <br />");
		
		out.println("<input type='hidden' name='name' value='" + name + "'/>");
		out.println("<button type= 'submit'>Next</button>");
		out.println("</form>");
	}

}
