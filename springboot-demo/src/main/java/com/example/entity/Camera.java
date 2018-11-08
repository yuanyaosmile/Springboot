package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yuanyao on 2018/11/6.
 */
@Component
@Getter
@Setter
public class Camera {
    @Value("${barry.camera.brand}")
    public String brand;

    @Value("${barry.camera.category}")
    public String category;

    @Value("${barry.camera}")
    public String camera;
}
