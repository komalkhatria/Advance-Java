package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet2")
public class SurveyFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SurveyFeedback() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String name= request.getParameter("name");
		int age= Integer.parseInt(request.getParameter("age"));
		
		out.println("<form action='servlet3' method='post'>");
		out.println("<label for= 'feedback'>Feedback</label>");
		out.println("<textarea name='feedback' rows='4' cols='50'></textarea> <br />");
		
		out.println("<input type='hidden' name= 'name' value='" + name + "'/>");
		out.println("<input type='hidden' name= 'age' value='" + age + "'/>");
		out.println("<button type= 'submit'>Submit</button>");
		out.println("</form>");
	}

}
