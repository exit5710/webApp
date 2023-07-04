package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ActionServlet extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("testMaven ActionServlet /");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		System.out.println(getClass().getResource("/dataBaseInfo.properties"));
	}
}