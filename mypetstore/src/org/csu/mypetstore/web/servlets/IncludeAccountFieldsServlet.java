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
public class IncludeAccountFieldsServlet extends HttpServlet {
    private static final String VIEW_MYACCOUNT = "/WEB-INF/jsp/account/MyAccount.jsp";
    private String successUsername;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountService accountService = new AccountService();
        successUsername = (String) session.getAttribute("usernameMsg");
        Account account = accountService.getAccount(successUsername);
        session.setAttribute("successAcount",account);
        request.getRequestDispatcher(VIEW_MYACCOUNT).forward(request,response);

    }
}
