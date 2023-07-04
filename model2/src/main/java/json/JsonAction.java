package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import controller.Action;
import controller.ActionForward;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class JsonAction implements Action {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("JsonAction /");

		JsonArray jsonArray = new JsonArray();
		JsonObject item = new JsonObject();
		item.addProperty("nation", "korea");
		item.addProperty("name", "song");
		jsonArray.add(item);

		item = new JsonObject();
		item.addProperty("nation", "usa");
		item.addProperty("name", "jim");
		jsonArray.add(item);

		logger.info("jsonArray : " + jsonArray.toString());

		PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();

		return null;
	}
}