package edu.hznu.cliven.basicboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.hznu.cliven.basicboot.mapper")
public class BasicBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicBootApplication.class, args);
	}
}
