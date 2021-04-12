package com.docomo.transaction.data.repository;


import com.docomo.transaction.data.domain.TransactionEntity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository repository;


    @Test
    void testAllDataLoads(){
        List<TransactionEntity> data = repository.findAll();

        assertEquals(4, data.size(), "Data size does not match expectation");


    }

}
