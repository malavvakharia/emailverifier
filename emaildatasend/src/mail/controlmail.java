package mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controlmail
 */
@WebServlet("/controlmail.html")
public class controlmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("txtname");
		String email = request.getParameter("txtmail");
		
		String message="hi";
		
		IdPassword ip = new IdPassword();
		String id = ip.mailid();
		String password = ip.mailpassword();
		Mail.send(id,password,message,email);
	}

}
