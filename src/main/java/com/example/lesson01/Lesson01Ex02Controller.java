package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//jsp파일를 뿌릴떄는 @responsebody가 없는 controller을 사용한다/
public class Lesson01Ex02Controller {

	//요청url: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		//jsp경로(응답값인)를 return한다
		//return "/WEB-INF/jsp/lesson01/ex02.jsp";
		///WEB-INF/jsp/ 중간 경로.jsp
		return"lesson01/ex02";//jsp view 경로와 이름 
	}
}
