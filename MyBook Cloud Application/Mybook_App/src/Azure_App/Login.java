package Azure_App;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String newuser = request.getParameter("newuser");
		String emailid= request.getParameter("email");
		String mobileno = request.getParameter("mobile");
		LoginTable logintable = new LoginTable();
		//logintable.insertEntry("bipul", "129");
		//logintable.insertEntry("udayin", "129");
		if (logintable.validEntryUserId(name, password)) {
			//PrintWriter out = response.getWriter();
			//out.println("You are in the table");
			PersonalInfoTable pit = new PersonalInfoTable();
			String email = pit.getEmail(name);
			String mobile = pit.getMobile(name);
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("mobile", mobile);
			//request.getRequestDispatcher("profile.jsp").forward(request, response); 
			
			//request.getSession().setAttribute("name", name); // Login user.
		  
			response.sendRedirect("profile.jsp");
			
		} else {
			if (newuser.equals("no")) {
				//response.sendRedirect("login.jsp");
				PrintWriter out = response.getWriter();
				out.println("Wrong credentials");
			} else if (newuser.equals("yes")) {
				logintable.insertEntry(name, password);
				PersonalInfoTable pit = new PersonalInfoTable();
				pit.insertInfo(name, emailid, mobileno);
				PrintWriter out = response.getWriter();
				out.println("Successfully registered");
				PersonalObjectTable pot = new PersonalObjectTable();
				pot.createContainer(name);
				//response.sendRedirect("login.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("Please enter yes/no");
			}
			//PrintWriter out = response.getWriter();
			//out.println("You are not in the table");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
