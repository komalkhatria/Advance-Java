package store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/report")
public class ReportCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReportCard() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("name");
		String roll_no= request.getParameter("rollNo");
		int physics= Integer.parseInt(request.getParameter("phy"));
		int chemistry= Integer.parseInt(request.getParameter("chem"));
		int mathematics= Integer.parseInt(request.getParameter("math"));
		
		int totalMarks= physics + chemistry + mathematics;
		float percent= (totalMarks*100)/300;
		String div;
		if(percent>=80){
			div= "First";
		}
		else if(percent>=55) {
			div= "Second";
		}
		else if(percent>=35){
			div= "third";
		}
		else {
			div= "fail";
		}
		
		out.println("<h1>Report Card</h1>");
		out.println("<p><b>Name: </b>" + name + "</p>");
		out.print("<table style='border: 1px solid black'>");
		out.print("<tr><th>Marks obtained</th> <th>Percentage</th> <th>Division</th></tr>");
		out.print("<tr><td>" + totalMarks + "</td> <td>" + percent + "</td> <td>" + div + "</td> </tr>");
		out.print("</table>");
	}

}
