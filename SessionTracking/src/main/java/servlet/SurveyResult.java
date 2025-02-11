package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet3")
public class SurveyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SurveyResult() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		String feedback= request.getParameter("feedback");
		
		out.println("<p><b>Name:</b> " + name + "</p>");
		out.println("<p><b>Age:</b> " + age + "</p>");
		out.println("<p><b>Feedback:</b> " + feedback + "</p>");
	}

}
