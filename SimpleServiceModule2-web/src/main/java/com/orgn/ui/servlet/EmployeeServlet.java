package com.orgn.ui.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgn.ui.vo.Employee;

import java.rmi.RemoteException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.orgn.teg.SimpleServiceRemote;

public class EmployeeServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("----- EmployeeServlet -----");
        try {
        // Get the customer value submitted from index.jsp page through HttpServletRequest object
            String empId=request.getParameter("empId");
            String name=request.getParameter("name");
            
            String svcCall = getEmployeeDetails(empId);

            //Set the employee values into Employee Bean - a POJO class
            Employee employee = new Employee();
            employee.setEmpId(empId);
            employee.setName(name);
            employee.setMessage(svcCall);

            RequestDispatcher dispatcher=request.getRequestDispatcher("/welcome.jsp");
            //Set the employee instance into request for it to be available in the welcome.jsp page
            request.setAttribute("emp",employee);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private String getEmployeeDetails(String empId) {
    	String retValue = "";
    	SimpleServiceRemote bean = doLookup();
        try {
			retValue = bean.getMessage();//call bean method
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return retValue;
    }
    
    private SimpleServiceRemote doLookup() {
        Context context = null;
        SimpleServiceRemote bean = null;
        try {
            // 1. Obtaining Context
            context = new InitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = "java:app/SimpleServiceModule2-ejb-0.2/SimpleService!com.orgn.teg.SimpleServiceRemote";
            // 3. Lookup and cast
            bean = (SimpleServiceRemote) context.lookup(lookupName);

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
    
}