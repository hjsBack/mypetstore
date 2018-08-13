package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 梦 on 2017/3/28.
 */
public class SignInServlet extends HttpServlet {
    private static final String VIEW_SIGNIN = "/WEB-INF/jsp/account/login.jsp";
    private String msg;
    //private String siginMsg;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_SIGNIN).forward(request,response);

    }
}
