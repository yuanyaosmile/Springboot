package com.example.entity;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by yuanyao on 2018/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CameraTest {

    @Autowired
    Camera camera;

    @Test
    public void cameraTest() {
        assertThat(camera.brand).isEqualTo("canon");
        log.info("PASS!");
        log.info(camera.camera);
    }
}
