package com.basicframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.basicframe.*.mapper")
public class BasicframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicframeApplication.class, args);
	}
}
