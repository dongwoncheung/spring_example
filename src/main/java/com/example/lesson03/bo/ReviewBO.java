package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	//input:x(parameter가 없으니)
		//id
	//output: review(단건)
	
	public Review getReview(int id) {
		return reviewMapper.SelectReview(id);
	}
	//input: review(단건)
	//output: int(성공된 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	//addReviewAsField(4,"콤비네이션R","김바다", 5.0,"역시 맛있다!!!");
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review  ) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	//input: id + review
	//output: int (성공된 행의 갯수)
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	//input: id
	//ouput:
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
		
	}
}
