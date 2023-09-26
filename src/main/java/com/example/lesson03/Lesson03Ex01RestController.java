package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	
	@Autowired
	private ReviewBO reviewBo;
	//요청 url: http://localhost/lesson03/ex01
	//요청 url: http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review getReview(
			@RequestParam("id")int id // 필수 파리미터
			//@RequestParam(value="id")int id// 필수 파라미터 
			//@RequestParam(value="id", required=true)int id // 필수 파리미터
			//@RequestParam(value="id", required=false)Integer id //비필수 파라미터
			//@RequestParam(value="id", defaultValue="1")int id //비필수 파라미터 default값:1
			){
		return reviewBo.getReview(id);// 응답에 관련된 내용
	}
	
}
