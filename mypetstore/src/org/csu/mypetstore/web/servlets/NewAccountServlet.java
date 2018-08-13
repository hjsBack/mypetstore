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
public class NewAccountServlet extends HttpServlet {
    private static final String VIEW_MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private String username;
    private String password;
    private String repeatedPassword;
    private String newAccountMsg;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        password = request.getParameter("password");
        repeatedPassword = request.getParameter("repeatedPassword");

        HttpSession session = request.getSession();

        if(username == null || username.trim().equals("")) {
            newAccountMsg = "用户名必填";
            session.setAttribute("newAccountMsg",newAccountMsg);
            response.sendRedirect("viewNewAccount");
        }

        else if(password == null || password.trim().equals("")){
            newAccountMsg = "密码不能为空";
            session.setAttribute("newAccountMsg",newAccountMsg);
            response.sendRedirect("viewNewAccount");
        }
        else if(repeatedPassword == null || repeatedPassword.trim().equals("")){
            newAccountMsg = "确认密码不能为空";
            session.setAttribute("newAccountMsg",newAccountMsg);
            response.sendRedirect("viewNewAccount");
        }
        else if(!password.trim().equals(repeatedPassword.trim())){
            newAccountMsg = "两次密码不相同，请重新输入";
            session.setAttribute("newAccountMsg",newAccountMsg);
            response.sendRedirect("viewNewAccount");
        }
        else {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            AccountService accountService = new AccountService();
            if(accountService.getAccount(username) != null){
                newAccountMsg = "该用户名已存在";
                session.setAttribute("newAccountMsg",newAccountMsg);
                response.sendRedirect("viewNewAccount");
            }
            else {
                accountService.insertAccount(account);
                //newAccountMsg = "注册成功";
                session.setAttribute("msg","注册成功");
                request.getRequestDispatcher(VIEW_MAIN).forward(request,response);
            }

        }
    }
}
