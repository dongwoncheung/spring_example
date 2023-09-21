package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service// spring bean
public class UsedGoodsBO {
	
	@Autowired // spring bean(객체)을 가져오는것(Dependency Injection ->DI)
	private UsedGoodsMapper usedGoodsMapper;
	
	//input(controller로 부터 요청을 받음) : x(다주는걸로 나옴)
	//output(controller한데 돌려준다) : List<UsedGoods> 을 돌려준다
	public List<UsedGoods> getUsedGoodsList(){//컨트롤러 요청받고
		return usedGoodsMapper.selectUsedGoodsList();//레퍼지토리한데 돌려준다
	}
}
