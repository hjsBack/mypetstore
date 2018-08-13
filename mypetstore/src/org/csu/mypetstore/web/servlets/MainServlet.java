package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.service.CatalogService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by 梦 on 2017/3/14.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    private static final String MAIN = "WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        CatalogService catalogService = new CatalogService();
        List<String> productNameList = catalogService.getAllProductName();
        session.setAttribute("productNameList",productNameList);
        session.setAttribute("usernameMsg",null);
        request.getRequestDispatcher(MAIN).forward(request,response);
    }
}
