package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller + responsebody
public class Lesson02Ex01RestController {
	//요청 url : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods>ex01(){
		List<UsedGoods> usedGoodsList = ;
		return"usedGoodsList"; // jason으로 나온다
	}
}
