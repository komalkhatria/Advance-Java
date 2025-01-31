package store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/details")
public class PersonalDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PersonalDetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("name");
		String fname= request.getParameter("fname");
		String mname= request.getParameter("mname");
		String address= request.getParameter("address");
		String contact= request.getParameter("contact");
		
		out.println("Name: " + name);
		out.println("Father's name: " + fname);
		out.println("Mother's name: " + mname);
		out.println("Address: " + address);
		out.println("Contact: " + contact);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}