package net.gondor.articles.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gondor.constants.Session;
import net.gondor.support.Param;
import net.gondor.users.vo.UserVO;

/**
 * Servlet implementation class ViewWriteServlet
 */
public class ViewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewWriteServlet() {
        super();
        param = new Param();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = param.getStringParam(request, "error");
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute(Session.SESSION_INFO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/write.jsp");
		request.setAttribute("error", error);
		request.setAttribute("user", user);
		rd.forward(request, response);
	}

}
