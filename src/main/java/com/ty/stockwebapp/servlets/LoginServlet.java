package com.ty.stockwebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.stockwebapp.dao.UserDao;
import com.ty.stockwebapp.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	session.setAttribute("status", "active");
    	session.setAttribute("name", "active");
    	 User user = new UserDao().getUser(req.getParameter("email"), req.getParameter("password"));
    	 if(user != null) {
    		 RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
    		 dispatcher.forward(req, resp);
    	 }
    	 else
    	 {
    		 RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
    		 dispatcher.forward(req, resp);
    	 }
    }
}
