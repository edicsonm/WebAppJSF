package au.com.edimoto.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="logout", urlPatterns={"/logout"}, loadOnStartup=2)
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ejecutando Logout Servlet ... ");
		/*response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", new java.util.Date().toString());*/

        if (request.getSession(false) != null) {
          request.getSession(false).invalidate();
        }
        if (request.getSession() != null) {
          request.getSession().invalidate();
        }
//        System.out.println("request.getContextPath(): " + request.getContextPath());
//        response.sendRedirect(request.getScheme()+"://"+request.getServerName());
        response.sendRedirect(request.getContextPath());
	}

}
