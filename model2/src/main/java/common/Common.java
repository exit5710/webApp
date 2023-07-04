package common;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

public class Common {
	public static String parameterToJson(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		String line = null;

		try {
			BufferedReader reader = request.getReader();

			while ((line = reader.readLine()) != null) {
				sb.append(line); //firstName=111&lastName=22&gender=f&minutes=33&seconds=44&action=addRunner
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsonData = "{" + sb.toString() + "}";
		jsonData = jsonData.replaceAll("=", ":");
		jsonData = jsonData.replaceAll("&", ",");
		//jsonData = "{firstName:111,lastName:22,gender:f,minutes:33,seconds:44}";

		return jsonData;
	}
}