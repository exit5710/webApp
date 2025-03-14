package servlet;

import controller.Action;
import controller.ActionForward;
import controller.UserActionFactory;

import customException.CustomException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Enumeration;

public class ActionServlet extends HttpServlet implements ServletContextListener {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private UserActionFactory uaf;

	public ActionServlet() {
		this.uaf = UserActionFactory.getInstance();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("model2 ActionServlet.service /");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		String contextName = request.getContextPath();
		String urlPattern = uri.substring(uri.lastIndexOf(".") + 1);
		String command = uri.substring(contextName.length(), uri.length() - (urlPattern.length() + 1));

		uaf = UserActionFactory.getInstance();
		Action action = uaf.action(command);

		if (action != null) {
			// ActionForward 역활은 뷰페이지와 이동할 경로의 방식을 결정하는 클래스
			ActionForward actionForward;

			try {
				actionForward = action.execute(request, response);

				if (actionForward.isRedirect()) {
					// redirect
					response.sendRedirect(contextName + actionForward.getPath());
				} else {
					// forward
					RequestDispatcher rd = request.getRequestDispatcher(actionForward.getPath());
					rd.forward(request, response);
				}
			} catch (SQLException | NullPointerException e) {
				// TODO: handle exception
				// json, 파일 다운로드는 리턴값이 null
				logger.error("message : " + e.toString());
			} catch (CustomException e) {
				logger.debug(e.toString());
			} catch (Exception e) {
				logger.error("exception : " + e.toString());
			}
		} else {
			// 유효하지 않는 command는 404error.jsp로 이동
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/error/404error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.info("model2 ActionServlet.contextDestroyed /");

		try {
			Enumeration<Driver> drivers = DriverManager.getDrivers();

			while (drivers.hasMoreElements()) {
				Driver driver = drivers.nextElement();
				DriverManager.deregisterDriver(driver);
				/*
				if (driver instanceof org.mariadb.jdbc.Driver || driver instanceof net.sf.log4jdbc.sql.jdbcapi.DriverSpy) {
					DriverManager.deregisterDriver(driver);
				}
				*/
			}
		} catch (SQLException e) {
			logger.error("exception : " + e.toString());
		}
	}
}