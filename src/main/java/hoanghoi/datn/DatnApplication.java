package hoanghoi.datn;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
// Import the required packages

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

@SpringBootApplication
@EnableDiscoveryClient
public class DatnApplication {



	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		ApplicationContext context = SpringApplication.run(DatnApplication.class, args);
		Environment env = context.getEnvironment();
		String cloudinaryUrl = env.getProperty("cloudinary.url");
		Cloudinary cloudinary = new Cloudinary(cloudinaryUrl);
		if(Objects.isNull(cloudinaryUrl) || cloudinaryUrl.isEmpty()) {
			throw new RuntimeException("loi cloudinary");
		}


	}
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
	}

}
