package racers.action;

import com.google.gson.Gson;
import common.Common;
import controller.Action;
import controller.ActionForward;
import customException.CustomException;
import dataBaseConnection.ConnectionLocator;
import dataBaseConnection.MariaDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racers.dao.RacerDao;
import racers.vo.RacerVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RacerSaveAction implements Action {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		logger.info("RacerSaveAction /");

		ConnectionLocator connectionLocator = MariaDataBase.getInstance();
		RacerDao racerDao = RacerDao.getInstance(connectionLocator);

		String jsonData = Common.parameterToJson(request);
		Gson gson = new Gson();
		RacerVo racerVo = gson.fromJson(jsonData, RacerVo.class);

		racerDao.insertRacer(racerVo);

		throw new CustomException("save");
	}
}