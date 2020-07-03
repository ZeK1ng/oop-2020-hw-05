package webPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.getRequestDispatcher("homePage.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountManager accM = (AccountManager) getServletContext().getAttribute("accManager");
		String uname = request.getParameter("username");
		String pw = request.getParameter("password");
		if(uname.trim().length() == 0 || pw.trim().length() == 0) {
			request.getRequestDispatcher("BadLoginInput.html").forward(request, response);
		}else {
			Account loginIn = accM.login(uname, pw);
			if(loginIn == null) {
				request.getRequestDispatcher("InvalidPassword.html").forward(request, response);
			}else {
				request.setAttribute("username", uname);
				request.getRequestDispatcher("WelcomeUser.jsp").forward(request, response);
			}
		}
		
	}

}
