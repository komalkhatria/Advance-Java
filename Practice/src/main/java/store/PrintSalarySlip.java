package store;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/displaySalary")
public class PrintSalarySlip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrintSalarySlip() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= (String) request.getAttribute("name");
		String empId= (String) request.getAttribute("empId");
		String dept= (String) request.getAttribute("dept");
		String designation= (String) request.getAttribute("designation");
		float basic= (float) request.getAttribute("basic");
		float allowances= (float) request.getAttribute("allowances");
		float deductions= (float) request.getAttribute("deductions");
		float grossSalary= (float) request.getAttribute("grossSalary");
		float netSalary= (float) request.getAttribute("netSalary");
		
		out.println("<link rel='stylesheet' type='text/css' href='salarySlip.css'>");

		out.println("<div>");
		out.println("<h1>Salary Slip</h1>");		
		out.println("<p>Name: " +name + " </p>");
		out.println("<p>Id: " + empId + " </p>");
		out.println("<p>Department: " + dept + " </p>");
		out.println("<p>Designation: " + designation + " </p>");
		out.println("<p>Basic Salary: " + basic + " </p>");
		out.println("<p>Allowances: " + allowances + " </p>");
		out.println("<p>Deductions: " + deductions + " </p>");
		out.println("<p>Gross Salary: " + grossSalary + " </p>");
		out.println("<p>Net Salary: " + netSalary + " </p>");
		out.println("</div>");
	}

}
