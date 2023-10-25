package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {
	
	//이번에만 bo생략함
	@Autowired
	private StudentRepository studentRepository;
	
	//조회하는 다양한 방법
	@GetMapping("/1")
	public List<StudentEntity> getStudentList(){
		//1)전체 조회(기본으로 제공되는 메소드)
		//return studentRepository.findAll();
		
		//2) 아이디 기준 내림차순으로 전체 조회
		//return studentRepository.findAllByOrderByIdDesc();
		
		//3)아이디 기준 내림차순 3개만 조회
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		//4)이름이 조세호인 데이터 조회(여러개 나올수있다)
		//return studentRepository.findByName("조세호");
		
		//5)in문으로 일피하는 값 모두 조회
		//return studentRepository.findByNameIn(List.of("유재석", "조세호", "정동원"));
		
		//6) 여러컬럼값과 일치하는 데이터 조회
		//return studentRepository.findByNameAndDreamJob("조세호", "변호사");
		
		//7) email 컬럼에 gmail이 포함된 컬럼명 조회(like문) - %gmail%
		//return studentRepository.findByEmailContaining("gmail");
		
		//8)이름이 조로 시작하는 데이터 조회(like) - 조%
		//return studentRepository.findByNameStartingWith("조");
		
		//9)id가 1번 부터 5번까지인 데이터를 조회(between)
		return studentRepository.findByIdBetween(1, 5);
		
	}
	@GetMapping("/2")
	public List<StudentEntity> getStudentList2(){
		//1) 장래희망이 래퍼인 데이터 조회
		return studentRepository.findByDreamJob("래퍼");
	}
}
