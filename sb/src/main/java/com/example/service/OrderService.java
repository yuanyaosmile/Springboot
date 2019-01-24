package com.example.service;

import com.example.domain.MiaoshaOrder;
import com.example.domain.OrderInfo;
import com.example.pojo.SkUser;
import com.example.vo.GoodsVo;

public interface OrderService {

    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId);

    OrderInfo createOrder(SkUser user, GoodsVo goods);
}
