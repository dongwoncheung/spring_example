package com.example.lesson06;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;
@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	@Autowired
	private UserBO userBO;
	
	/*
	 * // -----ex02-----
	 * 
	 * @GetMapping("/ex02/join-view")// 브라우저에 주소를 쳐서 들어가야되는 방식이니까 get방식으로 가야된다
	 * public String joinView() { return"lesson06/join"; } //이름 중복 확인 -> ajax으로 부터
	 * 오는 요청(반드시 @ResponseBody어노테이션 해주기)
	 * 
	 * @RequestMapping("/ex01/is-duplication")
	 * 
	 * @ResponseBody public Map<String, Object> isDuplication(
	 * 
	 * @RequestParam("name") String name){
	 * 
	 * //db조회 boolean isDuplicated = userBO.existUserByName(name); //응답값
	 * //{"code":200, "is_duplication":true} Map<String, Object> result = new
	 * HashMap<>(); result.put("code", 200); result.put("is_duplication",
	 * isDuplicated); // true => 중복 return result; }
	 */
	//----ex02끝------
	
	//----- ex01 -----
		// 회원 정보 추가 화면  http://localhost/lesson06/ex01/add-user-view
		@GetMapping("/ex01/add-user-view") // 주소를 치고 들어가는 형식이니까 get방식
		public String addUserView() {// view로 볼거니까 string형식
			return "lesson06/addUser";
		}
		
		// 회원 추가 기능 -- AJAX가 하는 요청 => 응답값은 String이어야 한다.
		@PostMapping("/ex01/add-user")
		@ResponseBody
		public String addUser(
				@RequestParam("name") String name,
				@RequestParam("yyyymmdd") String yyyymmdd,
				@RequestParam("email") String email,
				@RequestParam(value="introduce", required=false) String introduce) {
			
			// db insert
			userBO.addUser(name, yyyymmdd, email, introduce);
			
			return "성공";
		}
		
		// 결과 페이지
		@GetMapping("/ex01/get-latest-user")
		public String getLatestUser(Model model) {
			User user = userBO.getLatestUser();
			model.addAttribute("user", user);
			return "lesson06/getLatestUser";
		}
		
		//----- ex01 끝-----
}
