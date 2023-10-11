package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Controller
@RequestMapping("/lesson04/ex02")
public class Lesson04Ex02Controller {
	//url: http://localhost/lesson04/ex02/add-student-view
	//학생정보 추가 화면
	@Autowired
	private StudentBO studentBO;
	@GetMapping("/add-student-view")//browser에 주소를 치고 가니까 get방식
	public String addStudentView() {
		return"/lesson04/addStudent";
	}
	
	//가입 처리후 가입된 사람 정보 뿌려주기
	//url: http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // 태그의 name 속성과 일치하는 필드에 매핑된다( 하나하나씩 받는게 아니라 전체 객체를 파라미터에 넣는다)
			Model model) {
		//controller의 역할
		//1.db insert
		studentBO.addStudent(student);
		//2.db select (방금 가입된사람)
		int id = student.getId();// 이부분  디버그 한번 해보기
		Student latestStudent = studentBO.getStudentById(student.getId());
		model.addAttribute("student", latestStudent);
		return"lesson04/afterAddStudent";
	}
	
	
}
