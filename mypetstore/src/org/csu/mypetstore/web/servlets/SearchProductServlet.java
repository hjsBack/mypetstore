package org.csu.mypetstore.web.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.csu.mypetstore.service.CatalogService;

/**
 * Created by 梦 on 2017/3/19.
 */
public class SearchProductServlet extends HttpServlet {
    private static final String SEARCH_PRODUCT = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private String keyword;

    public SearchProductServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.keyword = request.getParameter("keyword");
        CatalogService service = new CatalogService();
        List productList = service.searchProductList(this.keyword);
        HttpSession session = request.getSession();
        session.setAttribute("productList", productList);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/SearchProducts.jsp").forward(request, response);
    }
}

