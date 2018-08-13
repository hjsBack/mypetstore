package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
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
public class LoginServlet extends HttpServlet {
    private static final String VIEW_SIGNIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private String username;
    private String password;
    //private String usernameMsg;
    //private String LoginMsg;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        password = request.getParameter("password");

        HttpSession session = request.getSession();

        if(username == null || username.trim().equals("")) {
//            LoginMsg = "用户名必填";
//            session.setAttribute("LoginMsg",LoginMsg);
            session.setAttribute("LoginMsg","用户名必填");
            response.sendRedirect("tc");
        }
        else if(password == null || password.trim().equals("")){
//            LoginMsg = "密码不能为空";
//            session.setAttribute("LoginMsg",LoginMsg);
            session.setAttribute("LoginMsg","密码不能为空");
            response.sendRedirect("tc");
        }
        else
        {
            AccountService accountService = new AccountService();
            Account tempAccount = accountService.getAccount(username,password);
            if(tempAccount == null){
//                LoginMsg = "您的用户名或密码不正确";
//                session.setAttribute("LoginMsg",LoginMsg);
                session.setAttribute("LoginMsg","您的用户名或密码不正确");
                response.sendRedirect("tc");
            }
            else {
                //accountService.insertOnline(username);
//                LoginMsg = "登录成功";
//                session.setAttribute("siginMsg",null);
//                session.setAttribute("signOutMsg",null);
//                session.setAttribute("LoginMsg",null);
//                session.setAttribute("queryMsg",null);
//                session.setAttribute("successUsername",username);
//                session.setAttribute("Success",LoginMsg);
                session.setAttribute("msg","登录成功");
                session.setAttribute("usernameMsg",username);
                request.getRequestDispatcher(VIEW_SIGNIN).forward(request,response);
            }
        }

    }
}
