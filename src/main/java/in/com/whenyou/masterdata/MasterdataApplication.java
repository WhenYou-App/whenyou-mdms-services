package in.com.whenyou.masterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MasterdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterdataApplication.class, args);
	}

}
