package com.docomo.transaction.application;

import com.docomo.transaction.generated.api.MerchantsApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.docomo.transaction" },scanBasePackageClasses = {MerchantsApi.class})
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
