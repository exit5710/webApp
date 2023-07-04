package springMVC.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@Controller
public class IndexController {
	@RequestMapping(value = "/")
	public String main(Model model) {
		model.addAttribute("title", "string5fs");

		System.out.println("------------------------>>>>");
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		Resource resource = defaultResourceLoader.getResource("classpath:resources/dataBaseInfo.properties");
		Resource resource1 = defaultResourceLoader.getResource("file:resources/dataBaseInfo.properties");

		System.out.println(resource);
		System.out.println(resource1);

		System.out.println("------------------------>>>>>>>");
		ClassPathResource classPathResource = new ClassPathResource("dataBaseInfo.properties");
		try {
			Path path = Paths.get(classPathResource.getURI());

			System.out.println("path : " + path);

			FileReader resources = new FileReader(path.toString());
			Properties properties = new Properties();
			properties.load(resources);
			System.out.println("----------------------------------------------------------------------");
			System.out.println(properties.getProperty("mariaDbUrl"));

			List<String> content = Files.readAllLines(path);
			content.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "index";
	}
}