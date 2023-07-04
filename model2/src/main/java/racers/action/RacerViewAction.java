package racers.action;

import controller.Action;
import controller.ActionForward;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RacerViewAction implements Action {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String path;

	public RacerViewAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		logger.info("RacerViewAction /");

		return new ActionForward(path);
	}
}