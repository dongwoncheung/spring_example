package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // spring bean, @controller + @responsebody
public class Lesson01Ex01RestController {
	
	//String 출력
	
	//요청 url: http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestContoller을 사용해 string 을 return해본다.</h3>";
	}
	
	// map을 출력 -> jason string으로 출력
	
	//요청 url : http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4(){
		Map<String, String> map = new HashMap<>();
		map.put("a", "1111");
		map.put("b", "2222");
		map.put("x", "3333");
		return map;
	}
	
	// 객체(내가만든 클래스) -> jason string으로 출력
	
	//요청 url : http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();// 객체 생성 / 일반 자바bean(spring이 관여 하지 않는다)
		data.setId(1);
		data.setName("정동원");
		return data; // 일반 자바 bean객체도 jason으로 내려간다.
		
	}
	//요청 url : http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data();// 객체 생성 / 일반 자바bean(spring이 관여 하지 않는다)
		data.setId(1);
		data.setName("정동원");
		//200 ok
		//return new ResponseEntity<>(data, HttpStatus.OK);
		//500에러
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
}
