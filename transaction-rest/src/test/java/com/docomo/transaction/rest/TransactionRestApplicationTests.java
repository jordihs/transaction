package com.docomo.transaction.rest;

import com.docomo.transaction.core.adapters.api.TransactionsServiceAPI;
import com.docomo.transaction.core.adapters.datasource.TransactionDataQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TransactionRestApplicationTests {

	@MockBean
	private TransactionsServiceAPI serviceAPI;


	@Test
	void contextLoads() {
	}

}
