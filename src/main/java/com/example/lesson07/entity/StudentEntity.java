package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString // 객체를 출력할때 모든 내용이 보여진다
@Getter
@AllArgsConstructor// 파라미터에 모두 있는 생성자
@Builder(toBuilder = true)// setter의 대용 / (toBuilder = true)=>수정허용 왜냐하면 setter대신에 사용되는 함수
@NoArgsConstructor // 파라미터없는 기본 생성자
@Entity(name = "new_student") // 이 객체는 entity다(jpa- db와 통신사이)
@Table(name="new_student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	
	@UpdateTimestamp// 시간을 넣지 않아도 현재시간으로 자동으로 들어감
	@Column(name = "createdAt", updatable = false)//나중에 업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp// 시간을 넣지 않아도 현재시간으로 자동으로 들어감
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
}
