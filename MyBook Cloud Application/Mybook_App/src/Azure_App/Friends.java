package Azure_App;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Friends
 */
@WebServlet("/Friends")
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friends() {
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
		FollowerTable ft = new FollowerTable();
		PersonalObjectTable pot = new PersonalObjectTable();
		MessageTable mt=new MessageTable();
		int count = 0;
		Iterable<FollowerEntity> followers = ft.getFollowers(user);
		for (FollowerEntity entity : followers) {
	          count +=1;
	        }
		String friends[][] =new String[count][100];
		String messages[][] =new String[count][100];
		String names[]=new String[count];
		int j=0;
		for (FollowerEntity entity : followers) {
			String nameoffriend = entity.getFollower();
			names[j]= nameoffriend;
	        friends[j] = pot.getObjects(nameoffriend);
	        messages[j]= mt.getMessages(nameoffriend);
	        for (int p=0;p<messages[j].length;p++) {
	        	if (messages[j][p]!=null) {
	        	System.out.println("hey"+messages[j][p]);
	        	}
	        }
	        j++;
	        }

		request.getSession().setAttribute("friendmes", messages);
		request.getSession().setAttribute("noms", names);
		request.getSession().setAttribute("friends", friends);
		response.sendRedirect("friends.jsp");
		
	}

}
