package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
//abcd
//vhjdsgthydyujs
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "🌟 Muazzam! GitHub Webhook tetiklendi, kod Jenkins'e ulasti ve Docker tarafindan basariyla guncellendi! (Yeni Versiyon v2.0)";
	}
}
