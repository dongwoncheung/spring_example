package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	@GetMapping("/ex01")
	public String ex01() {
		return"lesson05/ex01";
	}
	@GetMapping("/ex02")
	public String ex02(Model model) {
		//List<string>
		List<String> fruits = List.of("apple","melon", "peach", "grape", "mango");
		model.addAttribute("fruits", fruits); //list의 값을 모델안에 넣는 방법 ->model.addAttribute
		
		//List<Map<String, Object>>
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "정동원");
		user.put("age", 29);
		user.put("hobby", "유튜브시청");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "뽀로로");
		user.put("age", 9);
		user.put("hobby", "놀기");
		list.add(user);
		
		model.addAttribute("users", list);
		return"lesson05/ex02";
	}
}
