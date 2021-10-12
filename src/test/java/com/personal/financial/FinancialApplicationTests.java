package com.personal.financial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class FinancialApplicationTests {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

    }

}
