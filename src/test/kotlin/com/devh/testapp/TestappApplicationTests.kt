package com.devh.testapp

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.bind.annotation.RestController

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestappApplicationTests(@Autowired val restController: RestController) {

    @Test
    fun contextLoads() {
    }

}
