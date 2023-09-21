package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	
	//method
	//input(80-service ->DO 요청) : X
	//output: (BO service 돌려줌)List<usedGoods>
	public List<UsedGoods> selectUsedGoodsList();// db에 값을 담아 주는 역할
		
	
}
