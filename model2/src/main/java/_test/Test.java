package _test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Test {
	private final static Logger logger = LoggerFactory.getLogger(MethodHandle.class.getName());

	public static void main(String[] args) throws Exception {
		String path = Test.class.getResource("/dataBaseInfo.properties").getPath();
		FileReader resources = new FileReader(path);
		Properties properties = new Properties();

		try {
			properties.load(resources);
			logger.info(properties.getProperty("mariaDbUrl"));
			resources.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int number = 9;
		int division;
		try {
			division = number / 0;
			System.out.println(division);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}