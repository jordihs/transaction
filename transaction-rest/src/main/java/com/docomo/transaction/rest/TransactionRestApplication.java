package com.docomo.transaction.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.docomo.transaction.core.common","com.docomo.transaction.core.common.converter",
								"com.docomo.transaction.core.adapters.api.impl",
								"com.docomo.transaction.rest"})
public class TransactionRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionRestApplication.class, args);
	}

}
