package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	//Spring JPA DATA:JpaRepository
	
	//save(객체) -> (id없을시)inset도 되고 (id있을시)update도 된다 
	// findById()-> select
	
	//delete(객체(Entity)) -> delete
	
	//findAll -> 전체 조회를 제공을한다
	
	//JPQL문법 -> ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	
	public List<StudentEntity> findByNameStartingWith(String name);
	
	
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	//예제 ex02/2
	//1) JPQL DB로 직접 않가고 Entity로 조회
	//@Query(value = "select st from new_student st where st.dreamJob = :dreamJob")
	
	// 2) native query로 조회
	@Query(value = "select * from `new_student` where dreamJob = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob")String dreamJob);
	
	
	
	
}
