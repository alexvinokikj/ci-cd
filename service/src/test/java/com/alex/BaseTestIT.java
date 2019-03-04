package com.alex;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public abstract class BaseTestIT {

    @Value("${local.server.port}")
    private int port;


    protected String getBaseUrl() {
        return "http://localhost:" + port + "/";
    }

}
