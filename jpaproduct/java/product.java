package jpaproduct;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.io.PrintWriter;

import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;


public class product extends HttpServlet {
        @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws IOException, ServletException{

		String barcode=request.getParameter("barcode");
		String name=request.getParameter("name");
		String color=request.getParameter("color");
		String description=request.getParameter("description");

		List<String> result = new ArrayList<>(); 
		PrintWriter pwriter = response.getWriter();

		try {
			entity product = new entity(barcode,color,name,description);
			

			SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(entity.class)
									.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
                        session.beginTransaction();
			
			session.save(product);

			try {
				
				session.getTransaction().commit();
			
			}
			finally{}
			result.add(barcode);
			result.add(name);
			result.add(color);
			result.add(description);

			request.setAttribute("details",result);

			RequestDispatcher view = request.getRequestDispatcher("result.jsp");

			view.forward(request,response);

			factory.close();
			
		}catch(Exception exc){
                        pwriter.println("<p>An ERROR occured: Item already in database</p>"); 
			System.err.println("An error occurred while connecting PostgreSQL database: isi");
			exc.printStackTrace();
			System.out.println("\nError again my friend...");
		}
		pwriter.close();
        }
}