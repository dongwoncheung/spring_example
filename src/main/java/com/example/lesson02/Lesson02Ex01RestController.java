package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController // controller + responsebody
public class Lesson02Ex01RestController {
	
	@Autowired//DI (spring bean을 주입을한다)
	private UsedGoodsBO usedGoodsBO;
	//요청 url : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods>ex01(){
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList; // jason으로 나온다 - response body
	}
}
