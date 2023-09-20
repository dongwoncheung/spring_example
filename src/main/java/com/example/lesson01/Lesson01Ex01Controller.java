package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")// method에 붙은 주소 맵핑보다 먼져 적용
@Controller // 이부분이 있어야 spring 객체가 된다 -> spring객체임을 알려줌 / spring bean 등록
public class Lesson01Ex01Controller {
	//String 출력하기
	
	//요청url: http://localhost:8080/lesson01/ex01/1
	
	@RequestMapping("/1")// 주소매핑 /브라우저에서 치는 순간 요청이 들어감 
	@ResponseBody // return되는 string이  responsebody에 담겨서 보내준다
	public String ex01_1() {
		return"<h1>문자열을 responsebody로 보내는 예제<h1>";
//		String text = "<h1>문자열을 responsebody로 보내는 예제<h1>";
//		return text;
	}
	// map -> jason string 출력
	
	//요청 url : http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2(){
		Map<String,Object> map = new HashMap<>();
		map.put("apple", 33);
		map.put("banana", 145);
		map.put("orange", 125);
		map.put("grape", 21);
		//map을 return하면 jason으로 변경되어 출력된다 -> spring에 있는 의존성 라이브러리 떄문에 적용이된다
		//web starter에 jackson이라는 라이브러리가 포함되어있기때문
		return map;
	}
	
}
