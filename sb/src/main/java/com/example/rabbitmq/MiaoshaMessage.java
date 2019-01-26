package com.example.rabbitmq;

import com.example.pojo.SkUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiaoshaMessage {
    private SkUser user;

    private Long goodsId;
}
