package com.mccoy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mccoy.dao.BaseDao;
import com.mccoy.dao.BaseDaoImpl;
import com.mccoy.pojoclass.User;
import com.mccoy.util.HibernateUtil;


public class RegistrationController extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("userRegistration.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = "Password and Conform Passwords must be same";
  String page = "userRegistration.jsp";
  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
   User user = new User();
   user.setUsername(request.getParameter("username"));
   user.setPassword(request.getParameter("password"));
   user.setFirstName(request.getParameter("firstName"));
   user.setLastName(request.getParameter("lastName"));
   user.setDob(request.getParameter("dob"));
   user.setEmailId(request.getParameter("emailId"));
   user.setMobileNo(request.getParameter("mobileNo"));
   System.out.println(user.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.register(user);
   page = "login";
  } 
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}