package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	//C U D
	
	//c:create -> insert문
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "정동원";
		String phoneNumber = "010-4605-8546";
		String email = "xkfxhlrrtld@naver.com";
		String dreamjob = "건물주";
		// 지금들어간 id값도 바로꺼낼수있다 / getId();
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
		
	}
	
	//U -> Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id: 4 -> dreamjob을 다른걸로 변경
		//jason 으로 return
		return studentBO.updateStudentById(4, "의사");
	}
	
	// d: delete
	@GetMapping("/3")
	public String delete() {//id:11번을 제거 할거다
		studentBO.deleteStudentById(11);
		return"삭제완료";
	}
}
