package user_management_mcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class UserManagementMcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementMcsApplication.class, args);
	}

}
