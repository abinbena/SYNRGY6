package com.example.Chapter4;

import com.example.Chapter4.controller.HomeController;
import com.example.Chapter4.controller.MerchantController;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter4Application {

	public static void main(String[] args) {
		HomeController homeController = SpringApplication.run(Chapter4Application.class, args)
				.getBean(HomeController.class);
		homeController.home();

	}
}
