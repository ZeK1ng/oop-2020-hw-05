package webMarketPackage;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		ShoppingCart cart = (ShoppingCart) ses.getAttribute("shopping-cart"); 
		ProductCatalog cat = (ProductCatalog)getServletContext().getAttribute("productCatalog");
		if(cart == null) {
			cart = new ShoppingCart();
		}
		if(request.getParameter("id") != null) {
			cart.add(request.getParameter("id"),cat.getProduct(request.getParameter("id")).getPrice());
			request.setAttribute("shopping-cart", cart);
			ses.setAttribute("shopping-cart", cart);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request,response);
		}else {
			Enumeration<String> enumer= request.getParameterNames();
			while(enumer.hasMoreElements()) {
				String elem = enumer.nextElement();
				cart.add(elem, cat.getProduct(elem).getPrice(), Integer.parseInt(request.getParameter(elem)));
			}
			request.setAttribute("shopping-cart", cart);
			ses.setAttribute("shopping-cart", cart);
			request.getRequestDispatcher("shoppingCart.jsp").forward(request,response);
		}
		
	}

}
