package com.example.vinska;


import com.example.vinska.web.UserController;
import com.example.vinska.web.VinylController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VinskaApplicationTests {

    @Autowired
    private VinylController vinylController;

    @Autowired
    UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(vinylController).isNotNull();
        assertThat(userController).isNotNull();
    }
}
