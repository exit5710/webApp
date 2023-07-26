package common;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Common {
	public static String parameterToJson(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		String line;

		try {
			BufferedReader reader = request.getReader();

			while ((line = reader.readLine()) != null) {
				sb.append(line); //firstName=111&lastName=22&gender=f&minutes=33&seconds=44&action=addRunner
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String decodeResult = URLDecoder.decode(sb.toString(), StandardCharsets.UTF_8);
		String jsonData = "{" + decodeResult + "}";
		jsonData = jsonData.replaceAll("=", ":");
		jsonData = jsonData.replaceAll("&", ",");
		//jsonData = "{firstName:111,lastName:22,gender:f,minutes:33,seconds:44}";

		return jsonData;
	}
}