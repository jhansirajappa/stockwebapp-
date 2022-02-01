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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   HttpSession session=req.getSession();
       	if( ((String)session.getAttribute("name")).equals("active") ) {
       		new ItemDao().deleteItem(Integer.parseInt(req.getParameter("id")));
       		 RequestDispatcher dispatcher=req.getRequestDispatcher("getallitems");
       		 dispatcher.forward(req, resp);
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
