package Azure_App;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Personal
 */
@WebServlet("/Personal")
public class Personal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Personal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String) request.getSession().getAttribute("name");
		PersonalObjectTable pot = new PersonalObjectTable();
		String[] personal = pot.getObjects(user);
		MessageTable mt = new MessageTable();
		String[] messages = mt.getMessages(user);
		request.getSession().setAttribute("pmessage", messages);
		request.getSession().setAttribute("personal", personal);
		response.sendRedirect("personal.jsp");
		doGet(request, response);
	}

}
