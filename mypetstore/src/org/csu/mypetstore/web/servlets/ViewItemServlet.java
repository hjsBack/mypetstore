package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 梦 on 2017/3/19.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;

public class ViewItemServlet extends HttpServlet {
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private String itemId;

    public ViewItemServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.itemId = request.getParameter("itemId");
        CatalogService service = new CatalogService();
        Item item = service.getItem(this.itemId);
        HttpSession session = request.getSession();
        session.setAttribute("item", item);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/Item.jsp").forward(request, response);
    }
}

