package com.example.service.impl;

import com.example.domain.OrderInfo;
import com.example.pojo.SkUser;
import com.example.service.GoodsService;
import com.example.service.MiaoshaService;
import com.example.service.OrderService;
import com.example.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiaoshaoServiceImpl implements MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Override
    @Transactional
    public OrderInfo miaoshao(SkUser skUser, GoodsVo goodsVo) {

        //减库存，创建秒杀订单
        goodsService.reduceStock(goodsVo);

        //
        return orderService.createOrder(skUser, goodsVo);
    }
}
