package org.csu.mypetstore.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;
/**
 * Created by 梦 on 2017/3/19.
 */
public class AddItemToCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private String workingItemId;
    private Cart cart;
    private CatalogService catalogService;

    public AddItemToCartServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();
        this.cart = (Cart)session.getAttribute("cart");
        if(this.cart == null) {
            this.cart = new Cart();
        }

        if(this.cart.containsItemId(this.workingItemId)) {
            this.cart.incrementQuantityByItemId(this.workingItemId);
        } else {
            this.catalogService = new CatalogService();
            boolean isInStock = this.catalogService.isItemInStock(this.workingItemId);
            Item item = this.catalogService.getItem(this.workingItemId);
            this.cart.addItem(item, isInStock);
        }

        session.setAttribute("cart", this.cart);
        request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request, response);
    }
}

