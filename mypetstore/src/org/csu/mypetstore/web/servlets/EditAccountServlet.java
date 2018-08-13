package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 梦 on 2017/3/31.
 */
public class EditAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = new Account();
        account.setUsername(request.getParameter("username"));
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setEmail(request.getParameter("email"));
        account.setPhone(request.getParameter("phone"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setCity(request.getParameter("city"));
        account.setState(request.getParameter("state"));
        account.setZip(request.getParameter("zip"));
        account.setCountry(request.getParameter("country"));
        account.setLanguagePreference(request.getParameter("languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
        account.setListOption(!(request.getParameter("listOption") == null));
        account.setBannerOption(!(request.getParameter("bannerOption") == null));
        AccountService accountService = new AccountService();
        accountService.updateAccount(account);

        response.sendRedirect("includeAccountFields");
    }
}
