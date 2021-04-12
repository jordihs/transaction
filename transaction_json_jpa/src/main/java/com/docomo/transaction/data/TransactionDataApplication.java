package com.docomo.transaction.data;

import com.docomo.transaction.data.domain.TransactionEntity;
import com.docomo.transaction.data.json.FixedClassJSONResourceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.ResourceReader;

import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EntityScan(basePackages = {"com.docomo.transaction.data.domain"})
@EnableJpaRepositories(basePackages = {"com.docomo.transaction.data.repository"})
@ComponentScan(basePackages = {"com.docomo.transaction.core.common",
								"com.docomo.transaction.data"})
public class TransactionDataApplication {

	@Value("${datasource.file.url}")
	private Resource datasourceFile;

	@Autowired
	@Qualifier("standard")
	private DateTimeFormatter dateFormatter;

	public static void main(String[] args) {
		SpringApplication.run(TransactionDataApplication.class, args);
	}

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulator() throws MalformedURLException {
		final FixedClassJSONResourceReader reader = new FixedClassJSONResourceReader(TransactionEntity[].class,dateFormatter);
		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean(){
			@Override
			protected ResourceReader getResourceReader() {
				return reader;
			}
		};
		factory.setResources(new Resource[]{datasourceFile});
		return factory;
	}

}
