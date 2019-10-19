package classes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User {
	
	protected String username;
	protected String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void authen(String username, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*		
		if(username.equals("admin@isp.net") && password.equals("P@ssword1")) {
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
		else if(username.equals("") || password.equals("")) {
			request.getRequestDispatcher("index.jsp").include(request, response);
		} 
		else {
			response.setContentType("text/html");
			request.setAttribute("message", "Invalid username and/or password");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		*/
	}
}
