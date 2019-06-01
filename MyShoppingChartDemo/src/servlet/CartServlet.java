package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoughtItem;
import entity.ShoppingCart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		boolean success = false;
		if (action != null) {
			if(request.getParameter("action").equals("add")) {
				success = addIntoCart(request,response);
				if (success) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			
			
			if(action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			
			}
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	
	private boolean addIntoCart(HttpServletRequest request, HttpServletResponse response) {
		ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");
		if(sc==null) {
			sc = new ShoppingCart();
			request.getSession().setAttribute("cart", sc);
		}
		boolean isSuccessful = false; 
		
		if(request.getParameter("id")!=null && request.getParameter("num")!=null && sc!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			int num = Integer.parseInt(request.getParameter("num"));			
			while(num > 0) {
				isSuccessful = sc.addItems(id);
				num--;				
			}
			ArrayList<BoughtItem> bi = sc.getItemList();
	    	for(BoughtItem i:bi) {
	    		System.out.println(i.getName()+" "+i.getItemNum()+" "+i.getPrice());
	    	}
	    	System.out.println(sc.sumItemPrice());
			return isSuccessful;
		}else {
			return isSuccessful;
		}
		
	
	}

}
