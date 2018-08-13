package org.csu.mypetstore.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;

/**
 * Created by 梦 on 2017/3/19.
 */
public class RemoveItemFromCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private String workingItemId;
    private Cart cart;

    public RemoveItemFromCartServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();
        this.cart = (Cart)session.getAttribute("cart");
        Item item = this.cart.removeItemById(this.workingItemId);
        if(item == null) {
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");
            request.getRequestDispatcher("/WEB-INF/jsp/common/Error.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request, response);
        }

    }
}

