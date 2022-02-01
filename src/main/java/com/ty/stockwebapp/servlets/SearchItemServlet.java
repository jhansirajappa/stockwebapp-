package com.ty.stockwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.stockwebapp.dao.ItemDao;
import com.ty.stockwebapp.dto.Item;
@WebServlet("/searchitem")
public class SearchItemServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if( ((String)session.getAttribute("name")).equals("active") ) {
		String search=req.getParameter("search");
		String type=req.getParameter("type");
		if(search != null) {
			if(type !=null) {
				System.out.println(search+type);
				List<Item> items=new ItemDao().getAllItemsByType(search,type);
				session.setAttribute("myItem", items);
				RequestDispatcher dispatcher=req.getRequestDispatcher("displayitem.jsp");
				dispatcher.forward(req, resp);
			}
			else 
			{
				System.out.println(search+type);
			List<Item> items=new ItemDao().getAllItemsBySearch(search);
			session.setAttribute("myItem", items);
			RequestDispatcher dispatcher=req.getRequestDispatcher("displayitem.jsp");
			dispatcher.forward(req, resp);
			}
		}
			else if(type != null)
			{
				System.out.println(search+type);
				List<Item> items=new ItemDao().getAllItemsByType(type);
				session.setAttribute("myItem", items);
				RequestDispatcher dispatcher=req.getRequestDispatcher("displayitem.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("searchitem.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
		else
       	{
       		PrintWriter writer=resp.getWriter();
       		writer.print("<html><body><h1>Please Login</h1></body></html>");
       		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
      		 dispatcher.include(req, resp);
       	}
	}
}
