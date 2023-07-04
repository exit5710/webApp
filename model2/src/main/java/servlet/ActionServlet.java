package servlet;

import controller.Action;
import controller.ActionForward;
import controller.UserActionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ActionServlet extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logger.info("model2 ActionServlet /");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		String contextName = request.getContextPath();
		String urlPattern = uri.substring(uri.lastIndexOf(".") + 1);
		String command = uri.substring(contextName.length(), uri.length() - (urlPattern.length() + 1));

		UserActionFactory uaf = UserActionFactory.getInstance();
		Action action = uaf.action(command);

		if (action != null) {
			// ActionForward 역활은 뷰페이지와 이동할 경로의 방식을 결정하는 클래스
			ActionForward forward;

			try {
				forward = action.execute(request, response);
				if (forward.isRedirect()) {
					// redirect
					response.sendRedirect(contextName + forward.getPath());
				} else {
					// forward
					RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				// json, 파일 다운로드는 리턴값이 null
				//logger.error("message", e);
				logger.error(e.toString());
			}
		} else {
			// 유효하지 않는 command는 404error.jsp로 이동
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/error/404error.jsp");
			rd.forward(request, response);
		}
	}
}