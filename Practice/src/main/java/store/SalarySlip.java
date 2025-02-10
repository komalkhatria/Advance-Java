package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/salary")
public class SalarySlip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SalarySlip() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String name= request.getParameter("eName");
		String empId= request.getParameter("eId");
		String dept= request.getParameter("department");
		String designation= request.getParameter("designation");
		String doj= request.getParameter("doj");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		
		float basic= request.getParameter("basic") !=null ? Float.parseFloat(request.getParameter("basic")): 0;
		int leaves= request.getParameter("leaves") !=null ? Integer.parseInt(request.getParameter("leaves")): 0;
		String location= request.getParameter("location");
		String[] da= request.getParameterValues("da");
		
		float mi= 0, pf= 0, hra= 0, ta= 0;
		if(da!=null) {
			for(String s: da) {
				switch (s) {
                case "mi": mi = 500; break;
                case "pf": pf = (12 * basic) / 100; break;
                case "hra": hra = (20 * basic) / 100; break;
                case "ta": ta = 1000; break;
            }
			}
		}
		
		float leave= (basic/30)* leaves;
		float allowances= hra + ta;
		float grossSalary= basic + allowances;
		float deductions= mi + pf + leave;
		float netSalary= grossSalary- deductions;
		
		
		request.setAttribute("name", name);
		request.setAttribute("empId", empId);
		request.setAttribute("dept", dept);
		request.setAttribute("designation", designation);
		request.setAttribute("basic", basic);
		request.setAttribute("allowances", allowances);
		request.setAttribute("deductions", deductions);
		request.setAttribute("grossSalary", grossSalary);
		request.setAttribute("netSalary", netSalary);
		
		RequestDispatcher rd= request.getRequestDispatcher("/displaySalary");
		rd.forward(request, response);
			
	}

}
