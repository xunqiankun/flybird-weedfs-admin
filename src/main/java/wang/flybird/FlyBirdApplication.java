package wang.flybird;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wang.flybird.dao")
public class FlyBirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyBirdApplication.class, args);
	}
}
