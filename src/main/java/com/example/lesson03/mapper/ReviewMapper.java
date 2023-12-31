package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {

	public Review SelectReview(int id); 

	// return int(mybatis가 성공된 행의 개수를 리턴해준다)
	public int insertReview(Review review);
	public int insertReviewAsField(
			//파라미터가 2개이상이면 map으로 만든다(@param) => map으로 만들어 주는 어노테이션
			@Param("storeId")int storeId, 
			@Param("menu")String menu, 
			@Param("userName")String userName, 
			@Param("point")Double point, 
			@Param("review")String review);
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	public int deleteReviewById(int id);// bo가 받던 말던 상관없지만 int로 해도 가능 하다 void(리턴을 아에 않받는다는의미)
}
