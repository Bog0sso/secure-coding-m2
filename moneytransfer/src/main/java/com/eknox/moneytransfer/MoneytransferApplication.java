package com.eknox.moneytransfer;

import com.eknox.moneytransfer.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MoneytransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneytransferApplication.class, args);
	}
}
