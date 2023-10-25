package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	//mtdatis문법
	@Autowired
	private StudentMapper studentMapper; // mydatis로 호출
	
	@Autowired
	private StudentRepository studentRepository; // jpa로 호출
	
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	//jpa문법
	//INPUT: 파라미터들  OUTPUT: studentEntity
 	public StudentEntity addStudent(String name, String phoneNumber, 
 			String emial, String dreamJob) {
 		
 		// 다 세팅하고 완성된 상태로 쓰인다 완성적으로 객체를 만들어준다
 		StudentEntity student = StudentEntity.builder()
 				.name(name)
 				.phoneNumber(phoneNumber)
 				.email(emial)
 				.dreamJob(dreamJob)
 				.createdAt(ZonedDateTime.now()) // ZonedDateTime -> 세계 시간utc형태로 나온다 타임존까지 고려된거 하지만 생략가능 왜냐하면 @UpdateTimestamp 떄문에
 				.build();
 		
 		return studentRepository.save(student);
 	}
 	// input: id, dreamjob  // output: 변경된 studententity
 	public StudentEntity updateStudentById(int id, String dreamJob) {// dreamjob을 변경을 한다
 		StudentEntity student = studentRepository.findById(id).orElse(null);// optional method:orElse(null)->없으면 null로 설정할서다
 		if(student != null) {
 			//기존 값은 유지하고 세팅된 일부만 변경 -> dreamjob만 변경하는 함수는 toBuilder
 			student = student.toBuilder() //기존값을 유지 하지만뒤에있는 세팅된값만원하는dreamjob변경
 			.dreamJob(dreamJob)
 			.build();
 			
 			//update
 			studentRepository.save(student); //db에 업데이트후 다시 select된 결과
 			
 		}
 			return student;// null 또는 변경된 데이터
 	}
 	//input: id:11번 //output:x
 	public void deleteStudentById(int id) {
 		//1 번 방법
// 		StudentEntity student = studentRepository.findById(id).orElse(null);
// 		if(student != null) {
// 			studentRepository.delete(student);
// 					
// 		}
 		//2번방법(optional 객체의 방법)
 		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
 		studentOptional.ifPresent(s -> studentRepository.delete(s));//람다식 문법
 	}
 	
 	
}