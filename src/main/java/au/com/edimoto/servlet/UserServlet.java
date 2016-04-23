package au.com.edimoto.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -3159933339631291416L;
	private static final Logger logger = Logger.getLogger("au.com.edimoto.servlet.UserServlet");
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ejecutando el servlet por POST");
		logger.log(Level.INFO, "Parametros recibidos {0}: ", request.getParameterMap().toString());
		System.out.println("Ejecutando el servlet por GET");
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.INFO, "Parametros recibidos {0}: ", request.getParameterMap().toString());
		System.out.println("Ejecutando el servlet por GET");
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
