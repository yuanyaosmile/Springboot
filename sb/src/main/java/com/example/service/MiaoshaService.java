package com.example.service;

import com.example.domain.OrderInfo;
import com.example.pojo.SkUser;
import com.example.vo.GoodsVo;

public interface MiaoshaService {

    OrderInfo miaoshao(SkUser skUser, GoodsVo goodsVo);
}
