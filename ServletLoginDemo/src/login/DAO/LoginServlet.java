package login.DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Test Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User u = new User();
		String username,password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		u.setUsername(username);
		u.setPassword(password);
		request.getSession().setAttribute("regUser", u);
		if(username.equals("admin")&&password.equals("12345")) {			
			request.getRequestDispatcher("/LoginSuccessful.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/LoginFailed.jsp");
		}
	}

}
