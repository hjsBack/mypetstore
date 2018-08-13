package org.csu.mypetstore.web.servlets;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

/**
 * Created by 梦 on 2017/3/19.
 */
public class UpdateCartQuantitiesServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private Cart cart;

    public UpdateCartQuantitiesServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        this.cart = (Cart)session.getAttribute("cart");
        Iterator cartItems = this.cart.getAllCartItems();

        while(cartItems.hasNext()) {
            CartItem cartItem = (CartItem)cartItems.next();
            String itemId = cartItem.getItem().getItemId();

            try {
                int e = Integer.parseInt(request.getParameter(itemId));
                this.cart.setQuantityByItemId(itemId, e);
                if(e < 1) {
                    cartItems.remove();
                }
            } catch (Exception var8) {
                session.setAttribute("message", "The Quantities of Item must be Integer!");
                request.getRequestDispatcher("/WEB-INF/jsp/common/Error.jsp").forward(request, response);
            }
        }

        request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request, response);
    }
}

