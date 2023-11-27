package racers.action;

import com.google.gson.Gson;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class RacerListAction implements Action {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		logger.info("RacerListAction /");

		ConnectionLocator connectionLocator = MariaDataBase.getInstance();
		RacerDao racerDao = RacerDao.getInstance(connectionLocator);

		ArrayList<RacerVo> arrayList = racerDao.selectRacer();
		Gson gson = new Gson();
		String jsonString = gson.toJson(arrayList);

		PrintWriter out = response.getWriter();
		//out.println(jsonString);
		out.write(jsonString);
		out.flush();
		out.close();

		throw new CustomException("json");
	}
}